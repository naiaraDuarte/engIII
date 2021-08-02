<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EngIII</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="./css/custom/style.css">
        <link href="css/styleindex.css" rel="stylesheet" type="text/css" />
        <script src ="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script src="js/dist/jquery.inputmask.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
        <script src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.min.css" />
    </head>
    <body>

        <input type="checkbox" id="check">
        <!--header area start-->
        <header>

            <label for="check">
                <i class="fas fa-bars" id="sidebar_btn"></i>
            </label>
            <div class="left_area">
                <h3>Sis<span>ACad</span></h3>
            </div>
            <div class="right_area">
                <a href="#" class="logout_btn">Logout</a>
            </div>
        </header>
        <!--header area end-->
        <!--sidebar start-->
        <div class="sidebar">
            <center>
                <img src="./img/nay.jpeg" class="profile_image" alt="">
                <h4>Nay</h4>
            </center>
            <a href="./ListAluno.jsp"><i class="fas fa-desktop"></i><span>Aluno</span></a>
            <a href="./ListProfessor.jsp"><i class="fas fa-cogs"></i><span>Professor</span></a>
            <a href="./ListDisciplina.jsp"><i class="fas fa-table"></i><span>Disciplina</span></a>
            <a href="./ListTurma.jsp"><i class="fas fa-th"></i><span>Turma</span></a>
        </div>
        <!--sidebar end-->

        <div class="content" style="height: 98vh;">