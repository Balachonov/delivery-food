package balachonov.repositories;

import balachonov.dto.UserDTO;
import balachonov.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends GeneralOperation <String, User, UserDTO> {
        List<String> readUserOrders(UserDTO userDTO);
        Optional<User> readUserByEmail(String email);
        Optional<User> readUserByAddress(String address);
        List<User> readArchiveUsers ();

}
