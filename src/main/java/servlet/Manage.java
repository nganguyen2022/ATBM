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
                List<OrderProduct> exist = new ArrayList<>();

                for (OrderProduct od : dsDonHang.values()) {
                    String pub = acc.getTimePublicKey(od.getNameAcc());
                    System.out.println("pub:" + pub);
                    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    LocalDateTime newKeyTime = LocalDateTime.parse(pub, format);
                    System.out.println("newKeyTime: " + newKeyTime);

                    exist = dhDAO.getOrderByUser(od.getNameAcc());
                    System.out.println("exist Acc:" + exist);

                    System.out.println(od.toString());
                    Keys puk = AccountDAO.getKeyByUser(od.getNameAcc());
                    System.out.println("puk:" + puk);
                    List<Keys> puk0 = AccountDAO.getKey0ByUser(od.getNameAcc());
                    System.out.println("puk0:" + puk0);
                    List<String> publicKeyList = new ArrayList<>();

                    for (Keys keys : puk0) {
                        String publicKeyBase64 = keys.getPublicKey();
                        publicKeyList.add(publicKeyBase64);
                    }

                        if (puk != null && puk0 != null) {
                            List<DetailOrder> detailOders = detailOrderDAO.dsDHByMaDH(od.getIdOrder());
                            System.out.println("Chi tiết:" + detailOders);
                            if (!od.getStatus().equals("2") && !od.getStatus().equals("3")) {
                                System.out.println("Hậu");
                                try {
                                    boolean check = rsa.verify(od.getDataInitSignature(detailOders), od.getSignature(), puk.getPublicKey());
                                    System.out.println("check: " + check);
                                    boolean check1 = rsa.verifyListPubKey(od.getDataInitSignature(detailOders), od.getSignature(), publicKeyList);
                                    System.out.println("check1: " + check1);

                                    if (od != null && (od.getStatus().equals("0") || od.getStatus().equals("1") || od.getStatus().equals("-2"))) {
                                        System.out.println("Nga");
                                        LocalDateTime orderCreate = LocalDateTime.parse(od.getDateOrder(), format);
                                        System.out.println("Ngày tạo đơn: " + orderCreate);
                                        if (orderCreate.isAfter(newKeyTime)) {
                                            if (!check) {
                                                od.setStatus("-1");
                                                new OrderDAO().edit(od.getIdOrder(), od);
                                                System.out.println("haha1");
                                            } else if ("1".equals(od.getStatus())) {
                                                // Trong trường hợp ấn nút "Duyệt", giữ nguyên trạng thái là '1'
                                                // và cập nhật trạng thái trong cơ sở dữ liệu nếu kiểm tra thành công

                                                od.setStatus("1");
                                                new OrderDAO().edit(od.getIdOrder(), od);
                                                System.out.println("haha2");
                                            }
                                            if (!check && "1".equals(od.getStatus())) {
                                                od.setStatus("3");
                                                new OrderDAO().edit(od.getIdOrder(), od);
                                                System.out.println("haha3");
                                            }
                                            if (check){
                                                listOrder.add(od);
                                                continue;
                                            }
                                        }
                                        if (orderCreate.isBefore(newKeyTime)) {
                                            if (!check1) {
                                                od.setStatus("-1");
                                                new OrderDAO().edit(od.getIdOrder(), od);
                                                System.out.println("haha");
                                            } else if ("1".equals(od.getStatus())) {
                                                // Trong trường hợp ấn nút "Duyệt", giữ nguyên trạng thái là '1'
                                                // và cập nhật trạng thái trong cơ sở dữ liệu nếu kiểm tra thành công

                                                od.setStatus("1");
                                                new OrderDAO().edit(od.getIdOrder(), od);
                                                System.out.println("hihi");
                                            } else if (!check1 && "1".equals(od.getStatus())) {
                                                od.setStatus("3");
                                                new OrderDAO().edit(od.getIdOrder(), od);
                                                System.out.println("Tố Nga");
                                            } else {
                                                listOrder.add(od);
                                                continue;
                                            }

                                        }
                                    }
                                }catch (Exception e) {
                                    e.printStackTrace();
                                    od.setStatus("-1");
                                    new OrderDAO().edit(od.getIdOrder(), od);
                                    System.out.println(e.getMessage());
                                }
                            }
                        }

                    listOrder.add(od);
                }

                request.setAttribute("dsDonHang", listOrder);
                System.out.println("**************************");

                for (OrderProduct tmp : listOrder
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
