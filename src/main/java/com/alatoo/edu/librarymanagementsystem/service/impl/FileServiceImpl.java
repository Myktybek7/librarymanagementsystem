package com.alatoo.edu.librarymanagementsystem.service.impl;

import com.alatoo.edu.librarymanagementsystem.dto.AuthorDTO;
import com.alatoo.edu.librarymanagementsystem.dto.BookDTO;
import com.alatoo.edu.librarymanagementsystem.dto.CategoryDTO;
import com.alatoo.edu.librarymanagementsystem.dto.PublisherDTO;
import com.alatoo.edu.librarymanagementsystem.enums.Item;
import com.alatoo.edu.librarymanagementsystem.mapper.AuthorMapper;
import com.alatoo.edu.librarymanagementsystem.mapper.BookMapper;
import com.alatoo.edu.librarymanagementsystem.mapper.CategoryMapper;
import com.alatoo.edu.librarymanagementsystem.mapper.PublisherMapper;
import com.alatoo.edu.librarymanagementsystem.service.*;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Service
public class FileServiceImpl implements FileService {

	private final BookService bookService;

	private final AuthorService authorService;

	private final PublisherService publisherService;

	private final CategoryService categoryService;

	public FileServiceImpl(BookService bookService, AuthorService authorService, PublisherService publisherService,
			CategoryService categoryService) {
		this.authorService = authorService;
		this.categoryService = categoryService;
		this.publisherService = publisherService;
		this.bookService = bookService;
	}

	@Override
	public void exportCSV(String fileName, HttpServletResponse response)
			throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException, IOException {
		var item = Item.getItemByValue(fileName);
		response.setContentType("text/csv");
		response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
				"attachment; filename=\"" + item.get().getFileName() + "\"");

		switch (item.get()) {
		case BOOK:
			StatefulBeanToCsv<BookDTO> writer1 = getWriter(response.getWriter());
			writer1.write(BookMapper.bookModelToDTO(bookService.findAllBooks()));
			break;
		case AUTHOR:
			StatefulBeanToCsv<AuthorDTO> writer2 = getWriter(response.getWriter());
			writer2.write(AuthorMapper.authorModelToDto(authorService.findAllAuthors()));
			break;
		case CATEGORY:
			StatefulBeanToCsv<CategoryDTO> writer3 = getWriter(response.getWriter());
			writer3.write(CategoryMapper.categoryModelToDto(categoryService.findAllCategories()));
			break;
		case PUBLISHER:
			StatefulBeanToCsv<PublisherDTO> writer4 = getWriter(response.getWriter());
			writer4.write(PublisherMapper.publisherModelToDto(publisherService.findAllPublishers()));
			break;
		}

	}

	private static <T> StatefulBeanToCsv<T> getWriter(PrintWriter printWriter) {
		return new StatefulBeanToCsvBuilder<T>(printWriter).withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
				.withSeparator(CSVWriter.DEFAULT_SEPARATOR).withOrderedResults(false).build();
	}
}
