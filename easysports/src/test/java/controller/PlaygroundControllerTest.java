package controller;

import com.elec5619.easysports.controller.BookingsController;
import com.elec5619.easysports.controller.LoginController;
import com.elec5619.easysports.controller.PlaygroundController;
import com.elec5619.easysports.domain.User;
import com.elec5619.easysports.service.BookingService;
import com.elec5619.easysports.service.impl.UserServiceImpl;
import com.elec5619.easysports.utility.LoginUser;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.*;
import com.elec5619.easysports.utility.SessionUtil;
import javax.servlet.*;
import javax.servlet.http.*;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

public class PlaygroundControllerTest {
    SessionUtil mockutil=mock(SessionUtil.class);
    private MockMvc mockMvc;
    BookingsController bookingsController;
    PlaygroundController playgroundController;
    BookingService bookingService=mock(BookingService.class);
    Model mockmodle=mock(Model.class);
    LoginController loginController;
    SessionUtil sessionUtil=mock(SessionUtil.class);

    LoginUser mockuser=mock(LoginUser.class);
    UserServiceImpl mockuserService =mock(UserServiceImpl.class);
    private BookingsController BookingsController;


    @Before
    public void setup() throws IOException {
        this.bookingsController=new BookingsController();
        this.loginController=new LoginController();
        User user=new User();
        user.setPassword("1");
        when(mockuserService.findByEmail("yuanyi321@qq.com")).thenReturn(user);
        when(bookingService.getAllbookings(1)).thenReturn("{1:testing}");
        loginController.testuser(mockuserService);
//        HttpServletRequest request=getHttpServletRequest();
//        mockMvc = MockMvcBuilders.standaloneSetup(BookingsController).build();
//        request.getSession().setAttribute("loginUser", new LoginUser());
//        mockrequest.getSession().setAttribute("loginUser",mockuser);

    }
    @Test
    public void viewplayground() throws IOException {
        try{
            loginController.login("yuanyi321@qq.com","1",mockmodle,getHttpServletRequest());
        }catch (NullPointerException e){

        }


//        assertEquals("redirect:/manage",bookingsController.manage("1",mockmodle));
    }
    @Test
    public void booking() throws IOException{
        try {
            playgroundController.booking("1");
        }catch (NullPointerException e){

        }
    }
    @Test
    public void testlogin(){
        SessionUtil sessionUtil = new SessionUtil();
        //getHttpServletRequest();
        //LoginUser user = null;
        try{
            sessionUtil.getCurrentUser();
            fail();
        }catch(NullPointerException e){
        }
    }
    public HttpServletRequest getHttpServletRequest(){
        return new HttpServletRequest() {
            @Override
            public String getAuthType() {
                return null;
            }

            @Override
            public Cookie[] getCookies() {
                return new Cookie[0];
            }

            @Override
            public long getDateHeader(String s) {
                return 0;
            }

            @Override
            public String getHeader(String s) {
                return null;
            }

            @Override
            public Enumeration<String> getHeaders(String s) {
                return null;
            }

            @Override
            public Enumeration<String> getHeaderNames() {
                return null;
            }

            @Override
            public int getIntHeader(String s) {
                return 0;
            }

            @Override
            public String getMethod() {
                return null;
            }

            @Override
            public String getPathInfo() {
                return null;
            }

            @Override
            public String getPathTranslated() {
                return null;
            }

            @Override
            public String getContextPath() {
                return null;
            }

            @Override
            public String getQueryString() {
                return null;
            }

            @Override
            public String getRemoteUser() {
                return null;
            }

            @Override
            public boolean isUserInRole(String s) {
                return false;
            }

            @Override
            public Principal getUserPrincipal() {
                return null;
            }

            @Override
            public String getRequestedSessionId() {
                return null;
            }

            @Override
            public String getRequestURI() {
                return null;
            }

            @Override
            public StringBuffer getRequestURL() {
                return null;
            }

            @Override
            public String getServletPath() {
                return null;
            }

            @Override
            public HttpSession getSession(boolean b) {
                return null;
            }

            @Override
            public HttpSession getSession() {
                return getHttpSession();
            }

            @Override
            public boolean isRequestedSessionIdValid() {
                return false;
            }

            @Override
            public boolean isRequestedSessionIdFromCookie() {
                return false;
            }

            @Override
            public boolean isRequestedSessionIdFromURL() {
                return false;
            }

            @Override
            public boolean isRequestedSessionIdFromUrl() {
                return false;
            }


            @Override
            public Object getAttribute(String s) {
                return null;
            }

            @Override
            public Enumeration<String> getAttributeNames() {
                return null;
            }

            @Override
            public String getCharacterEncoding() {
                return null;
            }

            @Override
            public void setCharacterEncoding(String s) throws UnsupportedEncodingException {

            }

            @Override
            public int getContentLength() {
                return 0;
            }

            @Override
            public String getContentType() {
                return null;
            }

            @Override
            public ServletInputStream getInputStream() throws IOException {
                return null;
            }

            @Override
            public String getParameter(String s) {
                return null;
            }

            @Override
            public Enumeration<String> getParameterNames() {
                return null;
            }

            @Override
            public String[] getParameterValues(String s) {
                return new String[0];
            }

            @Override
            public Map<String, String[]> getParameterMap() {
                return null;
            }

            @Override
            public String getProtocol() {
                return null;
            }

            @Override
            public String getScheme() {
                return null;
            }

            @Override
            public String getServerName() {
                return null;
            }

            @Override
            public int getServerPort() {
                return 0;
            }

            @Override
            public BufferedReader getReader() throws IOException {
                return null;
            }

            @Override
            public String getRemoteAddr() {
                return null;
            }

            @Override
            public String getRemoteHost() {
                return null;
            }

            @Override
            public void setAttribute(String s, Object o) {

            }

            @Override
            public void removeAttribute(String s) {

            }

            @Override
            public Locale getLocale() {
                return null;
            }

            @Override
            public Enumeration<Locale> getLocales() {
                return null;
            }

            @Override
            public boolean isSecure() {
                return false;
            }

            @Override
            public RequestDispatcher getRequestDispatcher(String s) {
                return null;
            }

            @Override
            public String getRealPath(String s) {
                return null;
            }

            @Override
            public int getRemotePort() {
                return 0;
            }

            @Override
            public String getLocalName() {
                return null;
            }

            @Override
            public String getLocalAddr() {
                return null;
            }

            @Override
            public int getLocalPort() {
                return 0;
            }

        };
    }

    public HttpSession getHttpSession(){
        return new HttpSession() {
            @Override
            public long getCreationTime() {
                return 0;
            }

            @Override
            public String getId() {
                return null;
            }

            @Override
            public long getLastAccessedTime() {
                return 0;
            }

            @Override
            public ServletContext getServletContext() {
                return null;
            }

            @Override
            public void setMaxInactiveInterval(int i) {

            }

            @Override
            public int getMaxInactiveInterval() {
                return 0;
            }

            @Override
            public HttpSessionContext getSessionContext() {
                return null;
            }

            @Override
            public Object getAttribute(String s) {
                return null;
            }

            @Override
            public Object getValue(String s) {
                return null;
            }

            @Override
            public Enumeration<String> getAttributeNames() {
                return null;
            }

            @Override
            public String[] getValueNames() {
                return new String[0];
            }

            @Override
            public void setAttribute(String s, Object o) {

            }

            @Override
            public void putValue(String s, Object o) {

            }

            @Override
            public void removeAttribute(String s) {

            }

            @Override
            public void removeValue(String s) {

            }

            @Override
            public void invalidate() {

            }

            @Override
            public boolean isNew() {
                return false;
            }
        };
    }

}