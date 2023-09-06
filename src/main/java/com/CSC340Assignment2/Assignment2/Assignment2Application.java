package com.CSC340Assignment2.Assignment2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@SpringBootApplication
public class Assignment2Application {

	public static void main(String[] args) {
		SpringApplication.run(Assignment2Application.class, args);
		publicHoliday();
		fruitInfo();
	}

	public static void publicHoliday() {
		try {
			// Declare REST & Mapper variables
			String apiURL = "https://date.nager.at/api/v3/publicholidays/2023/US";
			RestTemplate restTemplate = new RestTemplate();
			ObjectMapper mapper = new ObjectMapper();

			// Declare JSON & Root variables
			String jSonHolidays = restTemplate.getForObject(apiURL, String.class);
			JsonNode root = mapper.readTree(jSonHolidays);

			// Declare variables that are initialized
			String holidayName = root.findValue("name").asText();
			String holidayDate = root.findValue("date").asText();

			// Print out information
			System.out.println("\n-------Holiday Information-------");
			System.out.println("Holiday Name: " + holidayName);
			System.out.println("Holiday Date: " + holidayDate + "\n");

		} catch (JsonProcessingException ex) {
			System.out.println("Error in publicHoliday");
		}
	}

	public static void fruitInfo() {
		try {
			// Declare REST & Mapper variables
			String apiURL = "https://www.fruityvice.com/api/fruit/Mango";
			RestTemplate restTemplate = new RestTemplate();
			ObjectMapper mapper = new ObjectMapper();

			// Declare JSON & Root variables
			String jSonFruitInfo = restTemplate.getForObject(apiURL, String.class);
			JsonNode root = mapper.readTree(jSonFruitInfo);

			// Declare variables that are initialized
			String fruitName = root.findValue("name").asText();
			String fruitFamily = root.findValue("family").asText();
			double fruitCals = root.findValue("calories").asDouble();
			double fruitSugar = root.findValue("sugar").asDouble();

			// Print out information
			System.out.println("-------Fruit Information-------");
			System.out.println("Fruit Name: " + fruitName);
			System.out.println("Fruit Family: " + fruitFamily);
			System.out.println("Fruit Calories: " + fruitCals);
			System.out.println("Fruit Sugars: " + fruitSugar);

		} catch (JsonProcessingException ex) {
			System.out.println("Error in fruitInfo");
		}
	}

}
