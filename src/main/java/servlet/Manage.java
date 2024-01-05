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
                RSAKey rsa = new RSAKey();
                for (OrderProduct od: dsDonHang.values()) {
                    //kiem tra chu ky
                    System.out.println(od.toString());
                    Keys puk = AccountDAO.getKeyByUser(od.getNameAcc());
                    List<DetailOrder> detailOders = new DetailOrderDAO().dsDHByMaDH(od.getIdOrder());
                    try {
                        //goi ham verify kiem tra lay dl ký dh tao chu ky moi và lay du lieu da ky trong db chu ky cũ
                        // của ng dung có trùng khong
                        boolean check = rsa.verify(od.getDataInitSignature(detailOders), od.getSignature(), puk.getPublicKey());
                        //khac nhau thì cap nhat status=-1 vafgoi ham update db
                        if(!check){
                            od.setStatus("-1");
                            new OrderDAO().edit(od.getIdOrder(), od);
                        }
                    }catch (Exception e){
                        od.setStatus("-1");
                        new OrderDAO().edit(od.getIdOrder(), od);
                    }
                    // end
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
