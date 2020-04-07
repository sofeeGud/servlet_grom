import com.fasterxml.jackson.databind.ObjectMapper;
import lesson2.HttpExсeption;
import lesson2.model.Item;
import lesson2.controller.ItemController;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = "/test")
public class MyServlet extends HttpServlet {

    private ItemController itemController = new ItemController();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            resp.getWriter().println(itemController.findById(Long.valueOf(req.getParameter("id"))).toString());
        }catch (Exception e){
            resp.getWriter().println(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            resp.getWriter().println("item was saved with id: "+itemController.save(new ObjectMapper().readValue(req.getInputStream(), Item.class)).getId());
        } catch (HttpExсeption e){
            resp.setStatus(e.getStatusCode());
            resp.getWriter().println(e.getMessage());
        }
        catch (Exception e){
            resp.setStatus(500);
            resp.getWriter().println(e.getMessage());
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            resp.getWriter().println("item was saved with id: "+itemController.update(new ObjectMapper().readValue(req.getInputStream(), Item.class)).getId());
        } catch (Exception e){
            resp.getWriter().println(e.getMessage());
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            resp.getWriter().println("item was saved with id: "+itemController.delete(Long.valueOf(req.getParameter("id"))).toString());
        } catch (Exception e){
            resp.getWriter().println(e.getMessage());
        }
    }
}
