<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: FallenAngel
  Time: 2020-10-16 下午 3:26
--%>
<%--@elvariable id="fileList" type="java.util.List<top.fallenangel.spring.mvc.entity.File>"--%>
<%--@elvariable id="file" type="top.fallenangel.spring.mvc.entity.File"--%>
<%--@elvariable id="folderId" type="java.lang.Integer"--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="u" uri="http://fallenangel.top/util/functions" %>
<html>
    <head>
        <title>文件列表</title>
        <script src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
        <script src="${pageContext.request.contextPath}/js/jQuery-File-Upload/js/vendor/jquery.ui.widget.js"></script>
        <script src="${pageContext.request.contextPath}/js/jQuery-File-Upload/js/jquery.iframe-transport.js"></script>
        <script src="${pageContext.request.contextPath}/js/jQuery-File-Upload/js/jquery.fileupload.js"></script>
        <script src="${pageContext.request.contextPath}/js/jQuery-File-Upload/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/js/jQuery-File-Upload/css/bootstrap.min.css">
        <link rel="stylesheet"
              href="${pageContext.request.contextPath}/js/jQuery-File-Upload/css/jquery.fileupload.css">
        <style type="text/css">
            .file-div {
                margin: 5px 10px;
            }

            .file-img {
                width: 32px;
                height: 32px;
            }

            .file-name-span {
                margin-left: 10px;
                cursor: pointer;
            }
        </style>
    </head>
    <body>
        <span class="btn btn-success fileinput-button">
                <i class="glyphicon glyphicon-plus"></i>
                <span>上传文件...</span>
                <input type="hidden" value="${folderId}">
                <input id="fileUpload" type="file" name="file" multiple="multiple">
            </span>
        <br/>
        <div id="files">
            <c:forEach items="${fileList}" var="file">
                <div class="file-div">
                    <input type="hidden" value="${file.fileRealName}"/>
                    <img alt="icon" class="file-img"
                         src="${pageContext.request.contextPath}/img/${u:extension(file.fileShowName)}.png">
                    <span class="file-name-span">${file.fileShowName}</span>
                </div>
            </c:forEach>
        </div>

        <script type="text/javascript">
            let fileUpload
            let folderId

            $(document).ready(function () {
                fileUpload = $("#fileUpload")
                folderId = fileUpload.prevAll("input").val()

                fileUpload.fileupload({
                    "url": "${pageContext.request.contextPath}/uploadFile?folderId=" + folderId,
                    "dataType": "json",
                    "done": function (e, data) {
                        let result = data.result

                        if (result.success) {
                            $("#files").append("<div class='file-div'><input type='hidden' value='" + result.fileRealName + "'/><img src='${pageContext.request.contextPath}/img/" + extension(result.fileRealName) + ".png' alt='icon' class='file-img'>\n<span class='file-name-span' onclick='downloadFile()' onmousedown='deleteFile(event)'>" + result.fileShowName + "</span></div>")
                        }
                    }
                })
            })

            let files = $(".file-name-span")

            files.click(downloadFile)

            function downloadFile() {
                let fileNameSpan

                if (this === window) {
                    fileNameSpan = $(".file-name-span:last")
                } else {
                    fileNameSpan = $(this)
                }

                let fileRealName = fileNameSpan.prevAll("input").val()
                location.href = "${pageContext.request.contextPath}/downloadFile?fileRealName=" + fileRealName
            }

            files.mousedown(event, deleteFile)

            function deleteFile(event) {
                if (event.which === 2) {
                    let fileNameSpan

                    if (this === window) {
                        fileNameSpan = $(".file-name-span:last")
                    } else {
                        fileNameSpan = $(this)
                    }

                    let fileRealName = fileNameSpan.prevAll("input").val()
                    location.href = "${pageContext.request.contextPath}/netDisk/deleteFile?fileRealName=" + fileRealName
                }
            }

            function extension(fileName) {
                let type = isEmpty(fileName) ? "unknown" : fileName.substring(fileName.lastIndexOf(".")).toLowerCase()
                let extension

                switch (type) {
                    case ".jpg":
                    case ".jpeg":
                    case ".png":
                    case ".gif":
                    case ".bmp":
                    case ".psd":
                        extension = "pic"
                        break
                    case ".mp4":
                    case ".avi":
                    case ".rmvb":
                    case ".mpeg":
                    case ".mov":
                    case ".3gp":
                    case ".wmv":
                        extension = "video"
                        break
                    case ".zip":
                    case ".rar":
                    case ".7z":
                        extension = "compress"
                        break
                    case ".txt":
                        extension = "txt"
                        break
                    case ".doc":
                    case ".docx":
                        extension = "word"
                        break
                    case ".xls":
                    case ".xlsx":
                        extension = "excel"
                        break
                    case ".ppt":
                    case ".pptx":
                        extension = "ppt"
                        break
                    case ".pdf":
                        extension = "pdf"
                        break
                    default:
                        extension = "unknown"
                }

                return extension
            }

            function isEmpty(str) {
                return str === undefined || "" === str.trim()
            }
        </script>
    </body>
</html>
