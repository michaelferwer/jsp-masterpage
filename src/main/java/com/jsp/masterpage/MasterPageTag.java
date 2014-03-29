package com.jsp.masterpage;

import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.util.Dictionary;
import java.util.Hashtable;

/**
 * Created by Michael on 26/02/14.
 */
public abstract class MasterPageTag extends BodyTagSupport{

    @SuppressWarnings("unchecked")
    public Dictionary<String, String> getParams() {
        Dictionary<String, String> params = (Dictionary<String, String>) pageContext.getAttribute("jsp-masterpage", PageContext.REQUEST_SCOPE);
        if (params == null) {
            params = new Hashtable<String, String>();
            pageContext.setAttribute("jsp-masterpage", params, PageContext.REQUEST_SCOPE);
        }
        return params;
    }

}
