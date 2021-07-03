package com.resonate.exercise.controller;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.resonate.exercise.config.TestConfig;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = { BookResource.class,
		TestConfig.class })
@AutoConfigureMockMvc
public class BookResourceTest {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void save_book_200() throws Exception {
		String bookInJson = "{\r\n" + "	\"rating\": \"5\",\r\n" + "    \"date\": \"2021-08-03T01:14:39.302+00:00\",\r\n"
				+ "    \"author\": \"Best Author\",\r\n" + "    \"title\": \"Test book\",\r\n"
				+ "    \"isbn\": \"as223fedfd\"\r\n" + "}";

		MvcResult result = mockMvc.perform(
				post("/api/v1/book/").content(bookInJson).header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
				.andExpect(status().is2xxSuccessful()).andReturn();
		String actualJson = result.getResponse().getContentAsString();
		assertEquals(actualJson, "{\"responseCode\":\"OK\",\"response\":\"The book create with ISBN: as223fedfd\"}");
	}

	@Test
	public void get_book_200() throws Exception {
		String bookInJson = "{\r\n" + "	\"rating\": \"5\",\r\n" + "    \"date\": \"2021-08-03T01:14:39.302+00:00\",\r\n"
				+ "    \"author\": \"Best Author\",\r\n" + "    \"title\": \"Test book\",\r\n"
				+ "    \"isbn\": \"as223fedfc\"\r\n" + "}";

		MvcResult result = mockMvc.perform(
				post("/api/v1/book/").content(bookInJson).header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
				.andExpect(status().is2xxSuccessful()).andReturn();
		String actualJson = result.getResponse().getContentAsString();
		assertEquals(actualJson, "{\"responseCode\":\"OK\",\"response\":\"The book create with ISBN: as223fedfc\"}");
		mockMvc.perform(get("/api/v1/book/as223fedfc", "").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().is2xxSuccessful());
	}

	@Test
	public void save_book_title_empty() throws Exception {
		String bookInJson = "{\r\n" + "	\"rating\": \"5\",\r\n" + "    \"date\": \"2021-08-03T01:14:39.302+00:00\",\r\n"
				+ "    \"author\": \"Best Author\",\r\n" + "    \"title\": \"\",\r\n"
				+ "    \"isbn\": \"as223fedfd\"\r\n" + "}";

		MvcResult result = mockMvc.perform(
				post("/api/v1/book/").content(bookInJson).header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
				.andExpect(status().is(400)).andReturn();
		String actualJson = result.getResponse().getContentAsString();
		assertEquals(actualJson, "{title=Please provide book title}");
	}

	@Test
	public void save_book_Auther_empty() throws Exception {
		String bookInJson = "{\r\n" + "	\"rating\": \"5\",\r\n" + "    \"date\": \"2021-08-03T01:14:39.302+00:00\",\r\n"
				+ "    \"author\": \"\",\r\n" + "    \"title\": \"Test book\",\r\n" + "    \"isbn\": \"as223fedfd\"\r\n"
				+ "}";

		MvcResult result = mockMvc.perform(
				post("/api/v1/book/").content(bookInJson).header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
				.andExpect(status().is(400)).andReturn();
		String actualJson = result.getResponse().getContentAsString();
		assertEquals(actualJson, "{author=Please provide book author}");
	}

	@Test
	public void save_book_Date_empty() throws Exception {
		String bookInJson = "{\r\n" + "	\"rating\": \"5\",\r\n" + "    \"date\": \"\",\r\n"
				+ "    \"author\": \"Best Author\",\r\n" + "    \"title\": \"Test book\",\r\n"
				+ "    \"isbn\": \"as223fedfd\"\r\n" + "}";

		MvcResult result = mockMvc.perform(
				post("/api/v1/book/").content(bookInJson).header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
				.andExpect(status().is(400)).andReturn();
		String actualJson = result.getResponse().getContentAsString();
		assertEquals(actualJson, "{date=Please provide Published date}");
	}

	@Test
	public void get_book_for_invalid_numeric_isin() throws Exception {
		try {
			mockMvc.perform(get("/api/v1/book/1234", "").contentType(MediaType.APPLICATION_JSON));
		} catch (Exception e) {
			assertTrue(e.getMessage().contains("ConstraintViolationException: getBook.isbn: Required Alphanumeric"));
		}
	}

	@Test
	public void get_book_for_invalid_aplpha_isin() throws Exception {
		try {
			mockMvc.perform(get("/api/v1/book/Abc", "").contentType(MediaType.APPLICATION_JSON));
		} catch (Exception e) {
			assertTrue(e.getMessage().contains("ConstraintViolationException: getBook.isbn: Required Alphanumeric"));
		}
	}
}
