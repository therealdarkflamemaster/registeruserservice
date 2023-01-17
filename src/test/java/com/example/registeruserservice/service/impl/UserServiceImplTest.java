package com.example.registeruserservice.service.impl;

import com.example.registeruserservice.model.User;
import com.example.registeruserservice.model.dto.UserException;
import com.example.registeruserservice.repository.IUserRepository;
import com.example.registeruserservice.service.intf.IUserService;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceImplTest {

    private IUserRepository userRepository = mock(IUserRepository.class);
    private IUserService userService = new UserServiceImpl(userRepository);

    @Test
    public void test_register() {
        User user1 = new User("usertest1",
                new GregorianCalendar(2000, Calendar.FEBRUARY, 11).getTime(),
                "france");
        User user2 = new User("usertest2",
                new GregorianCalendar(1998, Calendar.FEBRUARY, 11).getTime(),
                "France");

        when(userRepository.save(user1)).thenReturn(user1);
        when(userRepository.save(user2)).thenReturn(user2);

        assertEquals(user1, userService.register(user1));
        assertEquals(user2, userService.register(user2));
    }

    @Test
    public void test_fail_register() {
        User user1 = new User("usertest1",
                new GregorianCalendar(2020, Calendar.FEBRUARY, 11).getTime(),
                "france");
        User user2 = new User("usertest2",
                new GregorianCalendar(1998, Calendar.FEBRUARY, 11).getTime(),
                "Japan");

        {
            UserException thrownException = assertThrows(UserException.class,
                    () -> userService.register(user1));
            assertEquals("Not an adult", thrownException.getMessage());
        }

        {
            UserException thrownException = assertThrows(UserException.class,
                    () -> userService.register(user2));
            assertEquals("Not a france residence", thrownException.getMessage());
        }
    }

    @Test
    public void test_findUserById() {
        Long id = 1L;
        User user1 = new User("usertest1", new GregorianCalendar(2000, Calendar.FEBRUARY, 11).getTime(), "france");

        {
            when(userRepository.findById(id)).thenReturn(Optional.of(user1));

            assertEquals(user1, userService.findUserById(id).get());
        }

        {
            when(userRepository.findById(id)).thenReturn(Optional.empty());

            assertFalse(userService.findUserById(id).isPresent());
        }
    }
}
