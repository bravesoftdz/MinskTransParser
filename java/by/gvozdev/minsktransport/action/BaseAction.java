package by.gvozdev.minsktransport.action;

/**
 * @author Gvozdev Alexsander
 * Apr 23, 2018
 */

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BaseAction {

	void doHttpReqRes(HttpServletRequest request, HttpServletResponse response) throws IOException;

}
