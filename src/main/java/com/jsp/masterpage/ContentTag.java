package com.jsp.masterpage;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

/**
 * Created by Michael on 26/02/14.
 */
public class ContentTag extends MasterPageTag{

    private String placeholder;

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }


    @Override
    public int doAfterBody() throws JspException {
        getParams().put(placeholder, getBodyContent().getString());
        return SKIP_BODY;
    }

    @Override
    public void release() {
        setPlaceholder(null);
    }


}
