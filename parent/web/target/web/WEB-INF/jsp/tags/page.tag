<%@tag pageEncoding="UTF-8" description="分页" %>
<%@ attribute name="page" type="com.github.pagehelper.PageInfo" required="true" description="分页对象" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table width="100%" align="center">
    <tr>
    	<td>
    	<span class="page-info">[共有记录${page.total}条  / 共分${page.pages}页  ， 当前是第 ${page.pageNum} 页]</span >
    </td>
    </tr>
    <tr>
    	<td>	
        <c:choose>
            <c:when test="${page.pageNum==1}">
                	首页 &nbsp;&nbsp;
                	上一页&nbsp;&nbsp;
            </c:when>
            <c:otherwise>
                <a href="#" onclick="turnPage(1);" title="首页">首页</a>&nbsp;&nbsp;
                <a href="#" onclick="turnPage(${page.pageNum - 1});" title="上一页">上一页</a>&nbsp;&nbsp;
            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${page.pageNum==page.total}">
                	下一页&nbsp;&nbsp;
                	尾页&nbsp;&nbsp;
            </c:when>
            <c:otherwise>
                <a href="#" onclick="turnPage(${page.pageNum + 1});" title="下一页">下一页</a>&nbsp;&nbsp;
                <a href="#" onclick="turnPage(${page.total});" title="尾页">尾页</a>&nbsp;&nbsp;
            </c:otherwise>
        </c:choose>
        
</td>
</tr>
</table>