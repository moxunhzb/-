

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jqueryajax.dao.impl.ProvinceDaoImpl;
import com.jqueryajax.entity.Province;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class ProvinceJsonServlet
 */
@WebServlet("/ProvinceJsonServlet")
public class ProvinceJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProvinceJsonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");//设置响应的内容格式
        PrintWriter out = response.getWriter();
        ProvinceDaoImpl provinceDao = new ProvinceDaoImpl();
        List<Province> list = provinceDao.getAllProvince();//查询所有的省份
        //[{"provinceId":1,"provinceName":"陕西省"},...]
        JSONArray jsonArray = JSONArray.fromObject(list);
        System.out.print(jsonArray);
        out.print(jsonArray);
    }

}
