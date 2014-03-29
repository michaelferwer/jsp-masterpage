package com.jsp.masterpage;

import javax.servlet.jsp.JspException;
import java.util.Dictionary;

/**
 * Created by Michael on 26/02/14.
 */
public class PlaceholderTag extends MasterPageTag {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void release() {
        setName(null);
    }

    @Override
    public int doStartTag() throws JspException {
        Dictionary<String, String> params = getParams();

        String param = params.get(name);

        if (param != null) {
            try {
                pageContext.getOut().write(param);
            } catch (Exception exception) {
                throw new JspException(exception.getMessage());
            }
        }

        return SKIP_BODY;
    }

}
