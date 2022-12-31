<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Simple Calculator</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>

    <style>
        fieldset, legend, table,tr,td, h2, btn {
            border: 2px cornflowerblue;
            color: dodgerblue;
            font-family: "French Script MT";
        }
        input, select, option {
            border: 2px cornflowerblue;
            background-color: lightgoldenrodyellow;
            width: 100px;
            height: 30px;
        }
        td {
            width: 120px;
            height: 30px;
        }

    </style>
</head>

<body>

<h2> ==== Simple Calculator ==== </h2>

<form action="/simple-calculator" method="post">

    <fielset>
        <legend> </legend>
        <table>
            <tr>
                <td> First Operand: </td>
                <td> <input type="number" name="first_operand" placeholder="123"> </td>
            </tr>

            <tr>
                <td> Operator: </td>
                <td>
                    <select name="operator" id="operator" >
                        <option name="ad" value="+" style="width: 20px; height: 20px">Addition</option>
                        <option name="su" value="-" style="width: 20px; height: 20px">Subtraction</option>
                        <option name="mu" value="*" style="width: 20px; height: 20px">Multiplication</option>
                        <option name="di" value="/" style="width: 20px; height: 20px">Division</option>
                    </select>
                </td>
            </tr>

            <tr>
                <td> Second Operand: </td>
                <td> <input type="number" name="second_operand" placeholder="456"> </td>
            </tr>

            <tr>
                <td></td>
                <td colspan="2">
                    <button type="submit" name="calculate" class="btn btn-outline-success">
                        Calculate
                    </button>
                </td>
            </tr>

        </table>
    </fielset>
</form>

</body>
</html>