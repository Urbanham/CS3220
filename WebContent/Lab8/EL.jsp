<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<title>EL Table</title>
</head>
<body>
<H1> EL TABLE LAB 8</H1>
<table class="table table-bordered table-striped">
    <tr>
        <th colspan="2">Arithmetic Operators</th>
        <th colspan="2">Relational Operators</th>
    </tr>

    <tr>
        <th><b>Expression</b></th>
        <th><b>Result</b></th>
        <th><b>Expression</b></th>
        <th><b>Result</b></th>
    </tr>

    <tr>
    	<!-- First expression -->
        <td>\${3+2-1}</td>
        <!-- Answer to Expression -->
        <td>${3+2-1}</td>
        <!-- First expression -->
        <td>\${1 < 2}</td>
        <!-- Answer to Expression -->
        <td>${1 < 2}</td>
    </tr>

    <tr>
    <!-- First expression -->
        <td>\${"1"+2 }</td>
        <td>${"1"+2 }</td>
        <!-- First expression -->
        <td>\${"a" < "b"}</td>
        <td>${"a" < "b"}</td>

    </tr>

    <tr>
    <!-- First expression -->
        <td>\${1+2*3+3/4}</td>
        <td>${1+2*3+3/4}</td>
        <!-- First expression -->
        <td>\${2/3 >= 3/2}</td>
        <td>${2/3 >= 3/2}</td>
    </tr>

    <tr>
    <!-- First expression -->
        <td>\${3%2}</td>
        <td>${3%2}</td>
        <!-- First expression -->
        <td>\${3/4 == 0.75}</td>
        <td>${3/4 == 0.75}</td>
    </tr>

    <tr>
    <!-- First expression -->
        <td> \${(8 div 2) mod 3 }</td>
        <td>${((8 div 2)mod 3)}</td>
        <!-- First expression -->
        <td>\${null== "test"}</td>
        <td>${null == "test"}</td>
    </tr>

    <tr>
        <th colspan="2"><b>Logical Operators</b></th>
        <th colspan="2"><code>empty</code><b> Operator</b></th>
    </tr>

    <tr>
        <th><b>Expression</b></th>
        <th><b>Result</b></th>
        <th><b>Expression</b></th>
        <th><b>Result</b></th>
    </tr>

    <tr>
    <!-- First expression -->
        <td>\${(1<2) && (4<3))}</td>
        <td>${((1<2) && (4<3))}</td>
        <!-- First expression -->
        <td>\${empty ""}</td>
        <td>${empty ""}</td>
    </tr>

    <tr>
    <!-- First expression -->
        <td>\${(1<2) || (4<3))}</td>
        <td>${((1<2) || (4<3))}</td>
        <!-- First expression -->
        <td>\${empty null}</td>
        <td>${empty null}</td>
    </tr>

    <tr>
    <!-- First expression -->
        <td>\${!(1<2))}</td>    
        <td>${(!(1<2))}</td>
        <!-- First expression -->
        <td>\${empty param.blah}</td>
        <td>${empty param.blah}</td>
    </tr>
</table>

</body>
</html>