package com.alura.literAluraChallenge.service;

import com.alura.literAluraChallenge.entities.Author;
import com.alura.literAluraChallenge.entities.Book;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Service
public class GutendexService {

    public List<Book> getBooks(String query) {
        String url = "https://gutendex.com/books/?search=" + query;
        StringBuilder response = new StringBuilder();
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(response.toString());
            JsonNode results = rootNode.get("results");
            List<Book> books = new ArrayList<>();
            for (JsonNode node : results) {
                Book book = new Book();
                book.setTitle(node.get("title").asText());
                book.setLanguage(node.get("languages").get(0).asText());
                book.setDownloads(node.get("download_count").asInt());
                System.out.println("book.toString() = " + book.getTitle());
                JsonNode authors = node.get("authors").get(0);
                System.out.println("authors.get(\"name\") = " + new Author(
                        authors.get("name").asText(),
                        authors.get("birth_year").asInt(),
                        authors.get("death_year").asInt()
                ).getName());
                book.setAuthor(new Author(
                        authors.get("name").asText(),
                        authors.get("birth_year").asInt(),
                        authors.get("death_year").asInt()
                ));
                books.add(book);
            }
            return books;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}