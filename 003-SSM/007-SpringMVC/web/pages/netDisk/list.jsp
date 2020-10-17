<%--
  Created by IntelliJ IDEA.
  User: FallenAngel
  Time: 2020-10-14 下午 9:56
--%>
<%--@elvariable id="LOGIN_USER" type="top.fallenangel.spring.mvc.entity.User"--%>
<%--@elvariable id="folderList" type="java.util.List<top.fallenangel.spring.mvc.entity.Folder>"--%>
<%--@elvariable id="folder" type="top.fallenangel.spring.mvc.entity.Folder"--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
        <title>个人网盘</title>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
        <style type="text/css">
            .folder-div {
                width: 100px;
                height: 100px;
                display: inline-block;
                margin: 15px 15px 0 0;
                text-align: center;
            }

            .folder-img {
                width: 80px;
                height: 80px;
                margin-bottom: 5px;
                cursor: pointer;
            }

            .folder-name-span {
                width: 80px;
                cursor: pointer;
            }

            .folder-name-input {
                width: 80px;
            }
        </style>
    </head>
    <body>
        ${LOGIN_USER.userName}，欢迎！
        <br/>
        <button id="new-folder-btn" type="button">新建文件夹</button>
        <br/>
        <div id="folders">
            <c:forEach items="${folderList}" var="folder">
                <div class="folder-div">
                    <input type="hidden" value="${folder.folderId}"/>
                    <br/>
                    <img class="folder-img" src="${pageContext.request.contextPath}/img/folder.png" alt="文件夹图标"/>
                    <br/>
                    <span class="folder-name-span">${folder.folderName}</span>
                </div>
            </c:forEach>
        </div>

        <script type="text/javascript">
            let newFolderBtn = $("#new-folder-btn");

            newFolderBtn.click(function () {
                $.post(
                    "${pageContext.request.contextPath}/netDisk/newFolder",
                    {"folderName": "新建文件夹"},
                    function (data) {
                        let folderId = data.folderId
                        let folderName = data.folderName
                        let foldersDiv = $("#folders")

                        foldersDiv.append("<div class='folder-div'><input type='hidden' value='" + folderId + "'/><br/><img class='folder-img' src='${pageContext.request.contextPath}/img/folder.png' alt='文件夹图标' onclick='openFolder()' onmousedown='deleteFolder(event)'/><br/><input class='folder-name-input' value='" + folderName + "' onkeypress='keyPressedOnFolderNameInput(this, event)' onblur='commitFolderNameChange(this)'/></div>")
                        let folderNameInput = foldersDiv.find("input[class='folder-name-input']:last")
                        folderNameInput.focus()
                    }, "json"
                )
            })

            $(".folder-name-span").click(changeFolderName)

            function changeFolderName(span) {
                let folderNameSpan
                if (this === window) {
                    folderNameSpan = $(span)
                } else {
                    folderNameSpan = $(this)
                }

                let oldFolderName = folderNameSpan.text()
                let folderDiv = $(folderNameSpan).parent()
                folderNameSpan.remove()
                folderDiv.append("<input class='folder-name-input' value='" + oldFolderName + "' onkeypress='keyPressedOnFolderNameInput(this, event)' onblur='commitFolderNameChange(this)'/>")
                folderDiv.children("input[class='folder-name-input']").focus()
            }

            let folders = $(".folder-img")

            folders.click(openFolder)

            function openFolder() {
                let folder

                if (this === window) {
                    folder = $(".folder-img:last")
                } else {
                    folder = $(this)
                }

                let folderId = folder.prevAll("input").val()
                location.href = "${pageContext.request.contextPath}/netDisk/fileList?folderId=" + folderId
            }

            folders.mousedown(event, deleteFolder)

            function deleteFolder(event) {
                if (event.which === 2) {
                    let folder

                    if (this === window) {
                        folder = $(".folder-img:last")
                    } else {
                        folder = $(this)
                    }

                    let folderId = folder.prevAll("input").val()
                    location.href = "${pageContext.request.contextPath}/netDisk/deleteFolder?folderId=" + folderId
                }
            }

            function keyPressedOnFolderNameInput(input, event) {
                if (event.key.toLowerCase() === "enter") {
                    commitFolderNameChange(input)
                }
            }

            function commitFolderNameChange(input) {
                let folderDiv = $(input).parent()
                let folderId = folderDiv.children("input[type='hidden']").val()
                let newFolderName = $(input).val().trim()

                if (newFolderName === "") {
                    newFolderName = "未命名 " + new Date().toLocaleString()
                }

                $.ajax({
                    "url": "${pageContext.request.contextPath}/netDisk/modifyFolderName",
                    "type": "post",
                    "data": {"folderId": folderId, "newFolderName": newFolderName},
                    "dataType": "json",
                    "success": function (data) {
                        $(input).remove()
                        folderDiv.append("<span class='folder-name-span' onclick='changeFolderName(this)'>" + data.newFolderName + "</span>")
                    }
                })
            }
        </script>
    </body>
</html>