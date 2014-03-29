package com.jsp.masterpage;

import javax.servlet.jsp.JspException;

/**
 * Created by Michael on 26/02/14.
 */
public class MasterTag extends MasterPageTag {

    private String filename;

    public void setFilename(String filename){
        this.filename = filename;
    }

    @Override
    public int doStartTag () throws JspException {
        return EVAL_BODY_INCLUDE;
    }

    @Override
    public int doEndTag() throws JspException {
        try {
            pageContext.include(this.filename);
        } catch (Exception exception) {
            throw new JspException(exception.getMessage());
        }

        return EVAL_PAGE;
    }

    @Override
    public void release() {
        setFilename(null);
    }

}
