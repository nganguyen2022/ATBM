package servlet;


import conn.*;
import models.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Servlet implementation class manageOder
 */
@WebServlet("/admin/manage")
public class Manage extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Manage() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String loai = request.getParameter("loai");
            String searchTxt = request.getParameter("searchTXT");
            String indexString = request.getParameter("index");
            HttpSession session = request.getSession();
            User tk = (User) session.getAttribute("userLogin");
            if (indexString == null) {
                indexString = "1";
            }
            if(loai.equals("oder")) {
                OrderDAO dhDAO = new OrderDAO();
                List<OrderProduct> listOrder = new ArrayList<>();
                Map<String, OrderProduct> dsDonHang = dhDAO.mapDonHang;
                for (OrderProduct od: dsDonHang.values()) {
                    listOrder.add(od);
                }
                request.setAttribute("dsDonHang", listOrder);
                request.getRequestDispatcher("/admin/ManageOder.jsp").forward(request, response);

            }
            if(loai.equals("product")) {
                Load load = new Load();
                int count = load.getAllProduct().size();
                request.setAttribute("listSP",load.getAllProduct());
                request.getRequestDispatcher("/admin/ManageProduct.jsp").forward(request, response);
            } else if (loai.equals("user")) {
                AccountDAO accDAO = new AccountDAO();
                int count = accDAO.mapAccount.size();

                List<User> listUser = accDAO.getAllUsers();

                request.setAttribute("listUser", listUser);

                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");

                request.getRequestDispatcher("/admin/manageUser.jsp").forward(request, response);
            }
                //            }else if(loai.equals("log")) {
//                System.out.println(LogDAO.mapLog);
//                request.setAttribute("listLog", LogDAO.mapLog);
//                request.getRequestDispatcher("/startbootstrap-sb-admin-2-master/manageLog.jsp").forward(request, response);
//            }
//            if(loai.equals("discountCode")) {
//                request.setAttribute("listDiscount", new DiscountCodeDAO().mapDiscount.values());
//                response.setContentType("application/json");
//                response.setCharacterEncoding("UTF-8");
//
//                request.getRequestDispatcher("/startbootstrap-sb-admin-2-master/ManageDiscountCode.jsp").forward(request, response);
//            }

            }catch(Exception e){
                e.printStackTrace();
            }


        }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        doGet(request, response);
    }

}
