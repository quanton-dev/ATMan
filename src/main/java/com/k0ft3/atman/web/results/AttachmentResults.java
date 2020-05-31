package com.k0ft3.atman.web.results;

import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import com.k0ft3.atman.domain.common.file.FileUrlCreator;
import com.k0ft3.atman.domain.model.attachment.Attachment;
import com.k0ft3.atman.utils.ImageUtils;

public class AttachmentResults {

    public static ResponseEntity<ApiResult> build(List<Attachment> attachments, FileUrlCreator fileUrlCreator) {
        List<ListableAttachment> result = new ArrayList<>();
        for (Attachment attachment : attachments) {
            result.add(new ListableAttachment(attachment, fileUrlCreator));
        }
        ApiResult apiResult = ApiResult.blank().add("attachments", result);
        return Result.ok(apiResult);
    }

    private static class ListableAttachment {

        private long id;
        private String fileName;
        private String fileType;
        private String fileUrl;
        private String previewUrl;
        private long userId;
        private long createdDate;

        ListableAttachment(Attachment attachment, FileUrlCreator fileUrlCreator) {
            this.id = attachment.getId().value();
            this.fileName = attachment.getFileName();
            this.fileType = attachment.getFileType();
            this.fileUrl = fileUrlCreator.url(attachment.getFilePath());
            if (attachment.isThumbnailCreated()) {
                this.previewUrl = ImageUtils.getThumbnailVersion(this.fileUrl);
            } else {
                this.previewUrl = "";
            }
            this.userId = attachment.getUserId().value();
            this.createdDate = attachment.getCreatedDate().getTime();
        }

        public long getId() {
            return id;
        }

        public String getFileName() {
            return fileName;
        }

        public String getFileType() {
            return fileType;
        }

        public String getFileUrl() {
            return fileUrl;
        }

        public String getPreviewUrl() {
            return previewUrl;
        }

        public long getUserId() {
            return userId;
        }

        public long getCreatedDate() {
            return createdDate;
        }
    }
}