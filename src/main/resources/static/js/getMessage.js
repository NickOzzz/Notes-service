function editUpdateForm(messageId, message) {
        $("body").css("background", "#ccc");
        $("html").css("overflow-y", "hidden");

        var scrollPosition = (Number(window.scrollY) + 200).toString();
        $("#update-note-popup").css("top", scrollPosition);
        $("#update-note-popup").css("visibility", "visible");

        document.getElementById("update-note-input").value = messageId;
        document.getElementById("update-note-textarea").value = message;
    }

    function closeUpdateForm() {
        $("body").css("background", "");
        $("html").css("overflow-y", "scroll");
        $("#update-note-popup").css("visibility", "hidden");
    }