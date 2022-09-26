package com.junyharang.config.logback.model;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Setter
public class SlackMessage {

    private static final String CHANNEL = "channel";
    private static final String USERNAME = "username";
    private static final String HTTP = "http";
    private static final String ICON_URL = "icon_url";
    private static final String ICON_EMOJI = "icon_emoji";
    private static final String UNFURL_MEDIA = "unfurl_media";
    private static final String UNFURL_LINKS = "unfurl_links";
    private static final String TEXT = "text";
    private static final String ATTACHMENTS = "attachments";
    private static final String LINK_NAMES = "link_names";

    private List<SlackAttachment> attach = new ArrayList<SlackAttachment>();
    private String channel = null;
    private String icon = null;
    private JsonObject slackMessage = new JsonObject();

    private String text = null;
    private String username = null;

    private boolean unfurlMedia = false;
    private boolean unfurlLinks = false;

    private boolean linkNames = false;

    public SlackMessage() {
    }

    public SlackMessage(String text) {
        this(null, null, text);
    }

    public SlackMessage(String username, String text) {
        this(null, username, text);
    }

    public SlackMessage(String channel, String username, String text) {
        if (channel != null) {
            this.channel = channel;
        }

        if (username != null) {
            this.username = username;
        }

        this.text = text;
    }

    public SlackMessage addAttachments(SlackAttachment attach) {
        this.attach.add(attach);

        return this;
    }

    /**
     * Convert SlackMessage to JSON
     *
     * @return JsonObject
     */
    public JsonObject prepare() {
        if (channel != null) {
            slackMessage.addProperty(CHANNEL, channel);
        }

        if (username != null) {
            slackMessage.addProperty(USERNAME, username);
        }

        if (icon != null) {
            if (icon.contains(HTTP)) {
                slackMessage.addProperty(ICON_URL, icon);
            } else {
                slackMessage.addProperty(ICON_EMOJI, icon);
            }
        }

        slackMessage.addProperty(UNFURL_MEDIA, unfurlMedia);
        slackMessage.addProperty(UNFURL_LINKS, unfurlLinks);
        slackMessage.addProperty(LINK_NAMES, linkNames);

        if (text == null) {
            throw new IllegalArgumentException("Missing Text field @ SlackMessage");
        } else {
            slackMessage.addProperty(TEXT, text);
        }

        if (!attach.isEmpty()) {
            slackMessage.add(ATTACHMENTS, this.prepareAttach());
        }

        return slackMessage;
    }

    private JsonArray prepareAttach() {
        final JsonArray attachs = new JsonArray();
        for (SlackAttachment attach : this.attach) {
            attachs.add(attach.toJson());
        }

        return attachs;
    }

    public SlackMessage removeAttachment(int index) {
        this.attach.remove(index);

        return this;
    }

    public SlackMessage setText(String message) {
        if (message != null) {
            this.text = message;
        }

        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        final SlackMessage that = (SlackMessage) o;

        if (unfurlMedia != that.unfurlMedia)
            return false;
        if (unfurlLinks != that.unfurlLinks)
            return false;
        if (linkNames != that.linkNames)
            return false;
        if (!Objects.equals(attach, that.attach))
            return false;
        if (!Objects.equals(channel, that.channel))
            return false;
        if (!Objects.equals(icon, that.icon))
            return false;
        if (!Objects.equals(text, that.text))
            return false;

        return !(!Objects.equals(username, that.username));

    }

    @Override
    public int hashCode() {
        int result = attach != null ? attach.hashCode() : 0;
        result = 31 * result + (channel != null ? channel.hashCode() : 0);
        result = 31 * result + (icon != null ? icon.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (unfurlMedia ? 1 : 0);
        result = 31 * result + (unfurlLinks ? 1 : 0);
        result = 31 * result + (linkNames ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SlackMessage{" + "attach=" + attach + ", channel='" + channel + '\'' + ", icon='" + icon + '\''
                + ", slackMessage=" + slackMessage + ", text='" + text + '\'' + ", username='" + username + '\''
                + ", unfurlMedia=" + unfurlMedia + ", unfurlLinks=" + unfurlLinks + ", linkNames=" + linkNames + '}';
    }
}