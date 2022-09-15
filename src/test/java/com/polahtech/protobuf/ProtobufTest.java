package com.polahtech.protobuf;

import com.polahtech.protobuf.generated.AddressBookProtos;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProtobufTest {

    private final String name = "Joe";
    private final String email = "asd@asd.com";
    private final int id = new Random().nextInt();
    private final String number = "0123456789";
    private final Path filePath = Paths.get("C:/Peti/Coding/java_sandbox_by_topic/etc/proto/address_book");

    // generate class first by: protoc -I=. --java_out=. addressbook.proto

    @Test
    void givenGeneratedProtobufClass_whenCreateClass_thenShouldCreateJavaInstance() {
        // when
        AddressBookProtos.Person person = AddressBookProtos.Person.newBuilder()
                .setName(name)
                .setEmail(email)
                .setId(id)
                .addNumbers(number)
                .build();
        // then
        assertEquals(name, person.getName());
        assertEquals(email, person.getEmail());
        assertEquals(id, person.getId());
        assertEquals(number, person.getNumbers(0));
    }

    @Test
    void givenAddressBookWithOnePerson_whenSaveAsAFile_shouldLoadFromFileToJavaClass() throws IOException {
        // given
        AddressBookProtos.Person person = AddressBookProtos.Person.newBuilder()
                .setName(name)
                .setEmail(email)
                .setId(id)
                .addNumbers(number)
                .build();

        AddressBookProtos.AddressBook addressBook = AddressBookProtos.AddressBook.newBuilder()
                .addPeople(person).build();

        // when
        FileOutputStream fileOutputStream = new FileOutputStream(filePath.toFile());
        addressBook.writeTo(fileOutputStream);
        fileOutputStream.close();

        // then
        FileInputStream fileInputStream = new FileInputStream(filePath.toFile());
        AddressBookProtos.AddressBook deserializedAddressBook = AddressBookProtos.AddressBook.newBuilder().mergeFrom(fileInputStream).build();
        fileInputStream.close();

        assertEquals(name, deserializedAddressBook.getPeople(0).getName());
        assertEquals(email, deserializedAddressBook.getPeople(0).getEmail());
        assertEquals(id, deserializedAddressBook.getPeople(0).getId());
        assertEquals(number, deserializedAddressBook.getPeople(0).getNumbers(0));
    }
}
