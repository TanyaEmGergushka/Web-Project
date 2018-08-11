package junitTest;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import model.db.UserDao;

public class UserTest {

	@Test
	public void ExistsUser() throws SQLException {
		assertTrue(UserDao.getInstanse().existsUser("tanya", "tanya"));
	}
}
