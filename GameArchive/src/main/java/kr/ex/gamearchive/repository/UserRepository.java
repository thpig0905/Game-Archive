package kr.ex.gamearchive.repository;

import kr.ex.gamearchive.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findUserByLoginId(String loginId);

    public void deleteById(Long id);

    @Query("SELECT u.image FROM User u WHERE u.id = :id")
    public String findUserImage(@Param("id") Long id);

    @Modifying
    @Query("UPDATE User u SET u.loginId = :loginId, u.password = :password, u.name = :name, u.email = :email, u.phone = :phone WHERE u.id = :id")
    void updateUser(@Param("id") Long id, @Param("loginId") String loginId, @Param("password") String password, @Param("name") String name, @Param("email") String email, @Param("phone") String phone);

    @Modifying
    @Query("UPDATE User u SET u.coin = u.coin + :addCoin WHERE u.id = :id")
    void addCoin(@Param("id") Long id, @Param("addCoin") int addCoin);

    @Modifying
    @Query("UPDATE User u SET u.coin = :coin WHERE u.id = :id")
    void updateCoin(@Param("id") Long id, @Param("coin") int coin);
}
