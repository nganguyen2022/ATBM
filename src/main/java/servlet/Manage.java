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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
                AccountDAO acc = new AccountDAO();
                String id = request.getParameter("idOrder");

                OrderDAO dhDAO = new OrderDAO();
                List<OrderProduct> listOrder = new ArrayList<>();
                Map<String, OrderProduct> dsDonHang = dhDAO.loadData();
                RSAKey rsa = new RSAKey();
                DetailOrderDAO detailOrderDAO = new DetailOrderDAO();


                for (OrderProduct od : dsDonHang.values()) {
                    String pub = acc.getTimePublicKey(od.getNameAcc());
                    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    LocalDateTime newKeyTime = LocalDateTime.parse(pub, format);

                    OrderProduct exist = dsDonHang.get(od.getNameAcc());
//                    if (exist == null){
//                        request.getRequestDispatcher("/admin/ManageOder.jsp").forward(request, response);
//                        return;
//                    }

                    System.out.println(od.toString());
                    Keys puk = AccountDAO.getKeyByUser(od.getNameAcc());
                    if (puk != null) {
                        List<DetailOrder> detailOders = new DetailOrderDAO().dsDHByMaDH(od.getIdOrder());
                        if(!od.getStatus().equals("2"))
                            try {
                                boolean check = rsa.verify(od.getDataInitSignature(detailOders), od.getSignature(), puk.getPublicKey());

                                if (!check) {
                                    if (exist != null && (exist.getStatus().equals("0") || exist.getStatus().equals("1"))){
                                        LocalDateTime orderCreate = LocalDateTime.parse(exist.getDateOrder(), format);
                                        if (orderCreate.isBefore(newKeyTime)){
                                            return;
                                        }
                                        else {
                                            od.setStatus("-1");
                                            new OrderDAO().edit(od.getIdOrder(), od);
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            od.setStatus("-1");
                            new OrderDAO().edit(od.getIdOrder(), od);
                        }

                        listOrder.add(od);
                    }
                }

                request.setAttribute("dsDonHang", listOrder);
                System.out.println("**************************");

                for (OrderProduct tmp: listOrder
                ) {
                    System.out.println(tmp.toString());

                }
                System.out.println("**************************");

                request.getRequestDispatcher("/admin/ManageOder.jsp").forward(request, response);
            }

            if(loai.equals("product")) {
                Load load = new Load();
                int count = load.getAllProduct().size();
                request.setAttribute("listSP", load.getAllProduct());
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
        } catch (Exception e) {
            e.printStackTrace();
            // Xử lý ngoại lệ theo yêu cầu của bạn
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
