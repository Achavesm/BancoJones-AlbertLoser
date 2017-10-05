package org.escoladeltreball.checker;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Servlet implementation class Checker
 */
@WebServlet("/Checker")
public class Checker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Checker() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		String name = request.getParameter("nombre");
		String surname = request.getParameter("apellido");
		String birthday = request.getParameter("nacimiento");
		int nif = Integer.parseInt(request.getParameter("nif"));
		String dni = request.getParameter("dni");
		String letterChain = "TRWAGMYFPDXBNJZSQVHLCKET";
		char letter = ' ';
		
		Connection connection = null;

		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/test1", "aleix", "jupiter");
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}
		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
		PreparedStatement stmt;
		try {
		stmt = connection.prepareStatement("SELECT * FROM cliente");
		ResultSet rs = (ResultSet) stmt.executeQuery();
		
		while (rs.next()) {
			System.out.println("nombre " + rs.getString("nombre"));
			System.out.println("pass " + rs.getString("contraseña"));
			System.out.println("dni " + rs.getString("dni"));
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		name = name.replace(" ","");
		surname = surname.replace(" ", "");
		
		if (!name.matches("[a-zA-Z]*")) {
			request.setAttribute("errorName", "El nombre introducido es incorrecto");
		}
		if (!surname.matches("[a-zA-Z]*")) {
			request.setAttribute("errorSurname", "Los apellidos introducidos son incorrectos");
		}
		if (!birthday.matches("[0-9][0-9]/[0-9][0-9]/[0-9][0-9][0-9][0-9]")) {
			request.setAttribute("errorDate", "Introduzca la fecha en formato dd/mm/aaaa");
		}	
		String newNif = nif + "";
		if (newNif.matches("[0-9]{8}")) {
			letter = letterChain.charAt(nif%23);
		} else {
			request.setAttribute("errorNif", "El formato introducido es incorrecto");
		}
		if (dni.matches("[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][a-zA-Z]")) {
			if (dni.charAt(8) != letter) {
				request.setAttribute("errorDni", "La letra introducida es incorrecta");
			}
		} else {
			request.setAttribute("errorDni", "El formato del DNI es incorrecto");
		}
		
		request.setAttribute("name", name);
		request.setAttribute("surname", surname);
		request.setAttribute("birthday", birthday);
		request.setAttribute("nif", nif);
		request.setAttribute("dni", nif + "-" + letter);
		request.setAttribute("letter", letter);
		//response.getWriter().append("Served at: ").append(request.getContextPath());	
		request.getRequestDispatcher("/form.jsp").forward(request, response);
		}
		catch (Exception e) {
			request.getRequestDispatcher("/form.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
