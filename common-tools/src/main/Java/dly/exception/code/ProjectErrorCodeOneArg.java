package dly.exception.code;

import dly.exception.ProjectErrException;
import dly.exception.ProjectException;
import dly.exception.ProjectWarnException;

import java.text.MessageFormat;

public class ProjectErrorCodeOneArg extends ErrorCode {
    private MessageFormat format;

    public ProjectErrorCodeOneArg( String errCode, String errDesc )
    {
        this.errCode = errCode;
        this.format = new MessageFormat(errDesc);
    }

    public ErrorMsg format( String arg1 )
    {
        Object args[] = {arg1};
        return new ErrorMsg(errCode, format.format(args));
    }

    public ProjectException exception(String arg1 )
    {
        Object args[] = {arg1};
        return new ProjectErrException( errCode, format.format(args) );
    }
    public ProjectException exception2( String arg1 ,String arg2)
    {
        Object args[] = {arg1,arg2};
        return new ProjectErrException( errCode, format.format(args) );
    }
    public ProjectException exception( String arg1, Throwable cause )
    {
        Object args[] = {arg1};
        return new ProjectErrException( errCode, format.format(args), cause );
    }

    public ProjectException warn( String arg1 )
    {
        Object args[] = {arg1};
        return new ProjectWarnException( errCode, format.format(args) );
    }

    public ProjectException warn( String arg1, Throwable cause )
    {
        Object args[] = {arg1};
        return new ProjectWarnException( errCode, format.format(args), cause );
    }
}
