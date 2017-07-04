package com.rat.controlRefactor;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.rat.appRefactor.Rat;
import com.rat.dbutilRefactor.RatDbUtil;


/**
 * Servlet implementation class RatControlServlet
 */
@WebServlet("/RatControlServlet")
public class RatControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RatDbUtil ratDbUtil;
	

	@Resource(name = "jdbc/rat-web-project")
	private DataSource dataSource;

	@Override
	public void init() throws ServletException {
		super.init();

		// create our ratDbUtil ... and pass in the conn pool / data source
		try {
			ratDbUtil = new RatDbUtil(dataSource);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// read the command param
			String theCommand = request.getParameter("command");
			
			if (theCommand == null) {
				theCommand = "LIST";
			}

			switch (theCommand) {
			case "LIST":
				listRats(request, response);
				break;
			case "LOAD":
				loadRat(request, response);
				break;
			}
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// read the command param
			String theCommand = request.getParameter("command");

			
			// ---------------------------------- for testing -----------------------  //
			Enumeration<String> params = request.getParameterNames();
			while (params.hasMoreElements()) {
				String paramName = (String) params.nextElement();
				System.out
						.println("Parameter Name - " + paramName + ", \t\t Value - " + request.getParameter(paramName));
			}
			
			// ---------------------------------- for testing -----------------------  //

			if (theCommand == null) {
				doGet(request,response); //route back to the to get to list items.
			}
			// route to appropriate method
			switch (theCommand) {
			case "ADD":
				addRat(request, response);
				break;
			case "DELETE":
				deleteRat(request, response);
				break;
			case "EDIT":
				editRat(request, response);
				break;
			case "UPDATE":
				updateRat(request, response);
			}

		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	private void updateRat(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		// get original main claim number
		
		String[] mainClaim = request.getParameterValues("oldMainClaim");
		
		
		//Capture Rat data from form
		Rat tempRat = RatControlHelper.catureRat(request);
		
		ratDbUtil.updateRat(tempRat , mainClaim);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view-rat.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void editRat(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// read Rat id
		String mainClaim = request.getParameter("mainclaim");

		// get Rat from database(dbUtil)
		Rat theRat = ratDbUtil.getSelectedRat(mainClaim);


		// place Rat in the request attribute
		request.setAttribute("THE_RAT", theRat);

		// send to jsp page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/edit-rat.jsp");
		dispatcher.forward(request, response);
		
	}

	private void loadRat(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// read Rat id
		String ratId = request.getParameter("ratId");

		// get Rat from database(dbUtil)
		Rat theRat = ratDbUtil.getSelectedRat(ratId);

		// place Rat in the request attribute
		request.setAttribute("THE_RAT", theRat);

		// send to jsp page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view-rat.jsp");
		dispatcher.forward(request, response);

	}

	private void deleteRat(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// read Rat id of selected Rat
		String id = request.getParameter("id");

		// delete rat from db
		ratDbUtil.deleteRatFromDataBase(id);

		System.out.println("Deleting rat id " + id);
		// reload the student list.
		listRats(request, response);

	}

	private void addRat(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//Capture Rat data from form
		Rat tempRat = RatControlHelper.catureRat(request);
System.out.println("temp rat :::" + tempRat.getMainClaim().getClaimNumber());

		// add the rat to the Db
		ratDbUtil.addRat(tempRat);

		// send back to main page
		listRats(request, response);
	}

	private void listRats(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// get students from db util
		List<Rat> rats = ratDbUtil.getRats();

		// add students to request
		request.setAttribute("RAT_LIST", rats);

		// send to JSP page (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-rats.jsp");
		dispatcher.forward(request, response);
		return;

	}

	@SuppressWarnings("unused")
	private boolean arrIsEqual(String[] arr1, String[] arr2) {
		if (arr1.length > arr2.length || arr1.length < arr2.length) {
			System.out.println("arrays are not equal");
			return false;
		} else {
			return true;
		}
	}

}
