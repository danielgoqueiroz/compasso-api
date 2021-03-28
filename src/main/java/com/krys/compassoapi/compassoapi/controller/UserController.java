package com.krys.compassoapi.compassoapi.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.google.common.base.Strings;
import com.krys.compassoapi.compassoapi.model.User;

@RestController
@RequestMapping("/user")
public class UserController {

	Set<User> users = new HashSet<User>();

	@GetMapping(produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<?> getArtists(@RequestParam(required = false, name = "name") String name,
			@RequestParam(required = false, name = "id") Long id) {

		if (id != null) {
			Optional<User> findById = users.stream().filter(u -> id == u.getId()).findFirst();
			if (findById.isPresent()) {
				User user = findById.get();
				return ResponseEntity.ok(user);
			}
		}

		if (!Strings.isNullOrEmpty(name)) {

			Optional<User> findByName = users.stream().filter(u -> name.contentEquals(u.getName())).findFirst();
			if (findByName.isPresent()) {
				User user = findByName.get();
				return ResponseEntity.ok(user);
			}
		}
		return ResponseEntity.ok(users);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<?> save(@RequestBody User user) {

		validate(user);
		addUser(user);

		return ResponseEntity.ok(user);
	}

	private void addUser(User user) {
		long id = new Random().nextLong();
		user.setId(id < 0 ? id * -1 : id);
		users.add(user);
	}

	private void validate(User user) {

		if (Strings.isNullOrEmpty(String.valueOf(user.getId()))) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Foi enviado um usuário com o valor de id preenchido. Para salvar um novo usuário deve-se enviar sem o valor de id.");
		}
		if (Strings.isNullOrEmpty(user.getCpf()) || user.getCpf().length() < 8) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"O valor de CPF deve conter dados e deve ser maior que 8 caracteres.");
		}
		if (Strings.isNullOrEmpty(user.getCpf()) || user.getPassword().length() < 8) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"O valor de PASSWORD deve conter dados e deve ser maior que 8 caracteres.");
		}
		if (Strings.isNullOrEmpty(user.getName()) || user.getName().length() < 5) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"O valor de NOME deve conter dados e deve ser maior que 5 caracteres.");
		}
		Pattern patterEmail = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = patterEmail.matcher(user.getEmail());
		if (Strings.isNullOrEmpty(user.getEmail()) || !matcher.find()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O valor de EMAIL não é válido.");
		}

		Optional<User> findFirst = users
				.stream().filter(u -> user.getName().contentEquals(u.getName())
						|| user.getCpf().contentEquals(u.getCpf()) || user.getEmail().contentEquals(u.getEmail()))
				.findFirst();
		if (findFirst.isPresent()) {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}

	}

}
