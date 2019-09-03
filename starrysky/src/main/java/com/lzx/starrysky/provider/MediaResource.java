package com.lzx.starrysky.provider;

import android.text.TextUtils;

import java.util.HashMap;

public class MediaResource {
    private String mediaId;
    private long queueId;
    private String mediaUrl;
    private HashMap<String, MediaResource> mCacheMediaResource = new HashMap<>();

    private MediaResource(String mediaId, String mediaUrl, long queueId) {
        this.mediaId = mediaId;
        this.mediaUrl = mediaUrl;
        this.queueId = queueId;
    }

    public MediaResource() {
    }

    public MediaResource obtain(String mediaId, String mediaUrl, long queueId) {
        if (!TextUtils.isEmpty(mediaId)) {
            MediaResource resource = mCacheMediaResource.get(mediaId);
            if (resource == null) {
                resource = new MediaResource(mediaId, mediaUrl, queueId);
                mCacheMediaResource.put(mediaId, resource);
            }
            return resource;
        } else {
            throw new IllegalStateException("songId is null");
        }
    }

    public String getMediaId() {
        return mediaId;
    }

    public long getQueueId() {
        return queueId;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }
}