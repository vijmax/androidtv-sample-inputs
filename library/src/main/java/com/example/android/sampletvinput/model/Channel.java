/*
 * Copyright 2015 Google Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.sampletvinput.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.media.tv.TvContract;
import android.os.Build;
import android.text.TextUtils;

/**
 * A convenience class to create and insert channel entries into the database.
 */
public final class Channel {
    public static final long INVALID_LONG_VALUE = -1;
    public static final int INVALID_INTEGER_VALUE = -1;

    private long mId;
    private String mPackageName;
    private String mInputId;
    private String mType;
    private String mDisplayNumber;
    private String mDisplayName;
    private String mDescription;
    private String mChannelLogo;
    private String mVideoFormat;
    private int mOriginalNetworkId;
    private int mTransportStreamId;
    private int mServiceId;
    private String mAppLinkText;
    private int mAppLinkColor;
    private String mAppLinkIconUri;
    private String mAppLinkPosterArtUri;
    private String mAppLinkIntentUri;
    private byte[] mInternalProviderData;
    private boolean mIsRepeatable;

    private Channel() {
        mId = INVALID_LONG_VALUE;
        mOriginalNetworkId = INVALID_INTEGER_VALUE;
    }

    /**
     * @return The value of {@link TvContract.Channels#_ID} for the channel.
     */
    public long getId() {
        return mId;
    }

    /**
     * @return The value of {@link TvContract.Channels#COLUMN_PACKAGE_NAME} for the channel.
     */
    public String getPackageName() {
        return mPackageName;
    }

    /**
     * @return The value of {@link TvContract.Channels#COLUMN_INPUT_ID} for the channel.
     */
    public String getInputId() {
        return mInputId;
    }

    /**
     * @return The value of {@link TvContract.Channels#COLUMN_TYPE} for the channel.
     */
    public String getType() {
        return mType;
    }

    /**
     * @return The value of {@link TvContract.Channels#COLUMN_DISPLAY_NUMBER} for the channel.
     */
    public String getDisplayNumber() {
        return mDisplayNumber;
    }

    /**
     * @return The value of {@link TvContract.Channels#COLUMN_DISPLAY_NAME} for the channel.
     */
    public String getDisplayName() {
        return mDisplayName;
    }

    /**
     * @return The value of {@link TvContract.Channels#COLUMN_DESCRIPTION} for the channel.
     */
    public String getDescription() {
        return mDescription;
    }

    /**
     * @return The value of {@link TvContract.Channels#COLUMN_VIDEO_FORMAT} for the channel.
     */
    public String getVideoFormat() {
        return mVideoFormat;
    }

    /**
     * @return The value of {@link TvContract.Channels#COLUMN_ORIGINAL_NETWORK_ID} for the channel.
     */
    public int getOriginalNetworkId() {
        return mOriginalNetworkId;
    }

    /**
     * @return The value of {@link TvContract.Channels#COLUMN_TRANSPORT_STREAM_ID} for the channel.
     */
    public int getTransportStreamId() {
        return mTransportStreamId;
    }

    /**
     * @return The value of {@link TvContract.Channels#COLUMN_SERVICE_ID} for the channel.
     */
    public int getServiceId() {
        return mServiceId;
    }

    /**
     * @return The value of {@link TvContract.Channels#COLUMN_APP_LINK_TEXT} for the channel.
     */
    public String getAppLinkText() {
        return mAppLinkText;
    }

    /**
     * @return The value of {@link TvContract.Channels#COLUMN_APP_LINK_COLOR} for the channel.
     */
    public int getAppLinkColor() {
        return mAppLinkColor;
    }

    /**
     * @return The value of {@link TvContract.Channels#COLUMN_APP_LINK_ICON_URI} for the channel.
     */
    public String getAppLinkIconUri() {
        return mAppLinkIconUri;
    }

    /**
     * @return The value of {@link TvContract.Channels#COLUMN_APP_LINK_POSTER_ART_URI} for the
     * channel.
     */
    public String getAppLinkPosterArtUri() {
        return mAppLinkPosterArtUri;
    }

    /**
     * @return The value of {@link TvContract.Channels#COLUMN_APP_LINK_INTENT_URI} for the channel.
     */
    public String getAppLinkIntentUri() {
        return mAppLinkIntentUri;
    }

    /**
     * @return The value of {@link TvContract.Channels.Logo} for the channel.
     */
    public String getChannelLogo() {
        return mChannelLogo;
    }

    /**
     * @return Whether programs assigned to this channel should be repeated periodically.
     */
    public boolean isRepeatable() {
        return mIsRepeatable;
    }

    /**
     * @return The value of {@link TvContract.Channels#COLUMN_INTERNAL_PROVIDER_DATA} for the
     * channel.
     */
    public String getInternalProviderData() {
        if (mInternalProviderData != null) {
            return new String(mInternalProviderData);
        }
        return null;
    }

    /**
     * @return The value of {@link TvContract.Channels#COLUMN_INTERNAL_PROVIDER_DATA} for the
     * channel.
     */
    public byte[] getInternalProviderDataByteArray() {
        return mInternalProviderData;
    }

    @Override
    public String toString() {
        return "Channel{"
                + "id=" + mId
                + ", packageName=" + mPackageName
                + ", inputId=" + mInputId
                + ", originalNetworkId=" + mOriginalNetworkId
                + ", type=" + mType
                + ", displayNumber=" + mDisplayNumber
                + ", displayName=" + mDisplayName
                + ", description=" + mDescription
                + ", channelLogo=" + mChannelLogo
                + ", videoFormat=" + mVideoFormat
                + ", appLinkText=" + mAppLinkText + "}";
    }

    /**
     * @return The fields of the Channel in the ContentValues format to be easily inserted into the
     * TV Input Framework database.
     */
    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        if (mId != INVALID_LONG_VALUE) {
            values.put(TvContract.Channels._ID, mId);
        }
        if (!TextUtils.isEmpty(mPackageName)) {
            values.put(TvContract.Channels.COLUMN_PACKAGE_NAME, mPackageName);
        } else {
            values.putNull(TvContract.Channels.COLUMN_PACKAGE_NAME);
        }
        if (!TextUtils.isEmpty(mInputId)) {
            values.put(TvContract.Channels.COLUMN_INPUT_ID, mInputId);
        } else {
            values.putNull(TvContract.Channels.COLUMN_INPUT_ID);
        }
        if (!TextUtils.isEmpty(mType)) {
            values.put(TvContract.Channels.COLUMN_TYPE, mType);
        } else {
            values.putNull(TvContract.Channels.COLUMN_TYPE);
        }
        if (!TextUtils.isEmpty(mDisplayNumber)) {
            values.put(TvContract.Channels.COLUMN_DISPLAY_NUMBER, mDisplayNumber);
        } else {
            values.putNull(TvContract.Channels.COLUMN_DISPLAY_NUMBER);
        }
        if (!TextUtils.isEmpty(mDisplayName)) {
            values.put(TvContract.Channels.COLUMN_DISPLAY_NAME, mDisplayName);
        } else {
            values.putNull(TvContract.Channels.COLUMN_DISPLAY_NAME);
        }
        if (!TextUtils.isEmpty(mDescription)) {
            values.put(TvContract.Channels.COLUMN_DESCRIPTION, mDescription);
        } else {
            values.putNull(TvContract.Channels.COLUMN_DESCRIPTION);
        }
        if (!TextUtils.isEmpty(mVideoFormat)) {
            values.put(TvContract.Channels.COLUMN_VIDEO_FORMAT, mVideoFormat);
        } else {
            values.putNull(TvContract.Channels.COLUMN_VIDEO_FORMAT);
        }
        if (mInternalProviderData != null && mInternalProviderData.length > 0) {
            values.put(TvContract.Channels.COLUMN_INTERNAL_PROVIDER_DATA, mInternalProviderData);
        } else {
            values.putNull(TvContract.Channels.COLUMN_INTERNAL_PROVIDER_DATA);
        }
        values.put(TvContract.Channels.COLUMN_ORIGINAL_NETWORK_ID, mOriginalNetworkId);
        values.put(TvContract.Channels.COLUMN_TRANSPORT_STREAM_ID, mTransportStreamId);
        values.put(TvContract.Channels.COLUMN_SERVICE_ID, mServiceId);

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1) {
            values.put(TvContract.Channels.COLUMN_APP_LINK_COLOR, mAppLinkColor);
            if (!TextUtils.isEmpty(mAppLinkText)) {
                values.put(TvContract.Channels.COLUMN_APP_LINK_TEXT, mAppLinkText);
            } else {
                values.putNull(TvContract.Channels.COLUMN_APP_LINK_TEXT);
            }
            if (!TextUtils.isEmpty(mAppLinkIconUri)) {
                values.put(TvContract.Channels.COLUMN_APP_LINK_ICON_URI, mAppLinkIconUri);
            } else {
                values.putNull(TvContract.Channels.COLUMN_APP_LINK_ICON_URI);
            }
            if (!TextUtils.isEmpty(mAppLinkPosterArtUri)) {
                values.put(TvContract.Channels.COLUMN_APP_LINK_POSTER_ART_URI, mAppLinkPosterArtUri);
            } else {
                values.putNull(TvContract.Channels.COLUMN_APP_LINK_POSTER_ART_URI);
            }
            if (!TextUtils.isEmpty(mAppLinkIntentUri)) {
                values.put(TvContract.Channels.COLUMN_APP_LINK_INTENT_URI, mAppLinkIntentUri);
            } else {
                values.putNull(TvContract.Channels.COLUMN_APP_LINK_INTENT_URI);
            }
        }
        return values;
    }

    private void copyFrom(Channel other) {
        if (this == other) {
            return;
        }
        mId = other.mId;
        mPackageName = other.mPackageName;
        mInputId = other.mInputId;
        mType = other.mType;
        mDisplayNumber = other.mDisplayNumber;
        mDisplayName = other.mDisplayName;
        mDescription = other.mDescription;
        mVideoFormat = other.mVideoFormat;
        mOriginalNetworkId = other.mOriginalNetworkId;
        mTransportStreamId = other.mTransportStreamId;
        mServiceId = other.mServiceId;
        mAppLinkText = other.mAppLinkText;
        mAppLinkColor = other.mAppLinkColor;
        mAppLinkIconUri = other.mAppLinkIconUri;
        mAppLinkPosterArtUri = other.mAppLinkPosterArtUri;
        mAppLinkIntentUri = other.mAppLinkIntentUri;
        mChannelLogo = other.mChannelLogo;
        mInternalProviderData = other.mInternalProviderData;
        mIsRepeatable = other.mIsRepeatable;
    }

    /**
     * Creates a Channel object from a cursor including the fields defined in
     * {@link TvContract.Channels}.
     *
     * @param cursor A row from the TV Input Framework database.
     * @return A channel with the values taken from the cursor.
     */
    public static Channel fromCursor(Cursor cursor) {
        Builder builder = new Builder();
        int index = cursor.getColumnIndex(TvContract.Channels._ID);
        if (index >= 0 && !cursor.isNull(index)) {
            builder.setId(cursor.getLong(index));
        }
        index = cursor.getColumnIndex(TvContract.Channels.COLUMN_PACKAGE_NAME);
        if (index >= 0 && !cursor.isNull(index)) {
            builder.setPackageName(cursor.getString(index));
        }
        index = cursor.getColumnIndex(TvContract.Channels.COLUMN_INPUT_ID);
        if (index >= 0 && !cursor.isNull(index)) {
            builder.setInputId(cursor.getString(index));
        }
        index = cursor.getColumnIndex(TvContract.Channels.COLUMN_TYPE);
        if (index >= 0 && !cursor.isNull(index)) {
            builder.setType(cursor.getString(index));
        }
        index = cursor.getColumnIndex(TvContract.Channels.COLUMN_DISPLAY_NUMBER);
        if (index >= 0 && !cursor.isNull(index)) {
            builder.setDisplayNumber(cursor.getString(index));
        }
        index = cursor.getColumnIndex(TvContract.Channels.COLUMN_DISPLAY_NAME);
        if (index >= 0 && !cursor.isNull(index)) {
            builder.setDisplayName(cursor.getString(index));
        }
        index = cursor.getColumnIndex(TvContract.Channels.COLUMN_DESCRIPTION);
        if (index >= 0 && !cursor.isNull(index)) {
            builder.setDescription(cursor.getString(index));
        }
        index = cursor.getColumnIndex(TvContract.Channels.COLUMN_VIDEO_FORMAT);
        if (index >= 0 && !cursor.isNull(index)) {
            builder.setVideoFormat(cursor.getString(index));
        }
        index = cursor.getColumnIndex(TvContract.Channels.COLUMN_ORIGINAL_NETWORK_ID);
        if (index >= 0 && !cursor.isNull(index)) {
            builder.setOriginalNetworkId(cursor.getInt(index));
        }
        index = cursor.getColumnIndex(TvContract.Channels.COLUMN_TRANSPORT_STREAM_ID);
        if (index >= 0 && !cursor.isNull(index)) {
            builder.setTransportStreamId(cursor.getInt(index));
        }
        index = cursor.getColumnIndex(TvContract.Channels.COLUMN_SERVICE_ID);
        if (index >= 0 && !cursor.isNull(index)) {
            builder.setServiceId(cursor.getInt(index));
        }
        index = cursor.getColumnIndex(TvContract.Channels.COLUMN_INTERNAL_PROVIDER_DATA);
        if (index >= 0 && !cursor.isNull(index)) {
            builder.setInternalProviderData(cursor.getString(index));
        }

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1) {
            index = cursor.getColumnIndex(TvContract.Channels.COLUMN_APP_LINK_TEXT);
            if (index >= 0 && !cursor.isNull(index)) {
                builder.setAppLinkText(cursor.getString(index));
            }
            index = cursor.getColumnIndex(TvContract.Channels.COLUMN_APP_LINK_COLOR);
            if (index >= 0 && !cursor.isNull(index)) {
                builder.setAppLinkColor(cursor.getInt(index));
            }
            index = cursor.getColumnIndex(TvContract.Channels.COLUMN_APP_LINK_ICON_URI);
            if (index >= 0 && !cursor.isNull(index)) {
                builder.setAppLinkIconUri(cursor.getString(index));
            }
            index = cursor.getColumnIndex(TvContract.Channels.COLUMN_APP_LINK_POSTER_ART_URI);
            if (index >= 0 && !cursor.isNull(index)) {
                builder.setAppLinkPosterArtUri(cursor.getString(index));
            }
            index = cursor.getColumnIndex(TvContract.Channels.COLUMN_APP_LINK_INTENT_URI);
            if (index >= 0 && !cursor.isNull(index)) {
                builder.setAppLinkIntentUri(cursor.getString(index));
            }
        }
        return builder.build();
    }

    /**
     * The builder class that makes it easy to chain setters to create a {@link Channel} object.
     */
    public static final class Builder {
        private final Channel mChannel;

        public Builder() {
            mChannel = new Channel();
        }

        public Builder(Channel other) {
            mChannel = new Channel();
            mChannel.copyFrom(other);
        }

        /**
         * Sets the id of the Channel.
         *
         * @param id The value of {@link TvContract.Channels#_ID} for the channel.
         * @return This Builder object to allow for chaining of calls to builder methods.
         */
        public Builder setId(long id) {
            mChannel.mId = id;
            return this;
        }

        /**
         * Sets the package name of the Channel.
         *
         * @param packageName The value of {@link TvContract.Channels#COLUMN_PACKAGE_NAME} for the
         * channel.
         * @return This Builder object to allow for chaining of calls to builder methods.
         */
        public Builder setPackageName(String packageName) {
            mChannel.mPackageName = packageName;
            return this;
        }

        /**
         * Sets the input id of the Channel.
         *
         * @param inputId The value of {@link TvContract.Channels#COLUMN_INPUT_ID} for the channel.
         * @return This Builder object to allow for chaining of calls to builder methods.
         */
        public Builder setInputId(String inputId) {
            mChannel.mInputId = inputId;
            return this;
        }

        /**
         * Sets the broadcast standard of the Channel.
         *
         * @param type The value of {@link TvContract.Channels#COLUMN_TYPE} for the channel.
         * @return This Builder object to allow for chaining of calls to builder methods.
         */
        public Builder setType(String type) {
            mChannel.mType = type;
            return this;
        }

        /**
         * Sets the display number of the Channel.
         *
         * @param displayNumber The value of {@link TvContract.Channels#COLUMN_DISPLAY_NUMBER} for
         * the channel.
         * @return This Builder object to allow for chaining of calls to builder methods.
         */
        public Builder setDisplayNumber(String displayNumber) {
            mChannel.mDisplayNumber = displayNumber;
            return this;
        }

        /**
         * Sets the name to be displayed for the Channel.
         *
         * @param displayName The value of {@link TvContract.Channels#COLUMN_DISPLAY_NAME} for the
         * channel.
         * @return This Builder object to allow for chaining of calls to builder methods.
         */
        public Builder setDisplayName(String displayName) {
            mChannel.mDisplayName = displayName;
            return this;
        }

        /**
         * Sets the description of the Channel.
         *
         * @param description The value of {@link TvContract.Channels#COLUMN_DESCRIPTION} for the
         * channel.
         * @return This Builder object to allow for chaining of calls to builder methods.
         */
        public Builder setDescription(String description) {
            mChannel.mDescription = description;
            return this;
        }

        /**
         * Sets the logo of the channel.
         *
         * @param channelLogo The Uri corresponding to the logo for the channel.
         * @return This Builder object to allow for chaining of calls to builder methods.
         * @see TvContract.Channels.Logo
         */
        public Builder setChannelLogo(String channelLogo) {
            mChannel.mChannelLogo = channelLogo;
            return this;
        }

        /**
         * Sets the video format of the Channel.
         *
         * @param videoFormat The value of {@link TvContract.Channels#COLUMN_VIDEO_FORMAT} for the
         * channel.
         * @return This Builder object to allow for chaining of calls to builder methods.
         */
        public Builder setVideoFormat(String videoFormat) {
            mChannel.mVideoFormat = videoFormat;
            return this;
        }

        /**
         * Sets the original network id of the Channel.
         *
         * @param originalNetworkId The value of
         * {@link TvContract.Channels#COLUMN_ORIGINAL_NETWORK_ID} for the channel.
         * @return This Builder object to allow for chaining of calls to builder methods.
         */
        public Builder setOriginalNetworkId(int originalNetworkId) {
            mChannel.mOriginalNetworkId = originalNetworkId;
            return this;
        }

        /**
         * Sets the transport stream id of the Channel.
         *
         * @param transportStreamId The value of
         * {@link TvContract.Channels#COLUMN_TRANSPORT_STREAM_ID} for the channel.
         * @return This Builder object to allow for chaining of calls to builder methods.
         */
        public Builder setTransportStreamId(int transportStreamId) {
            mChannel.mTransportStreamId = transportStreamId;
            return this;
        }

        /**
         * Sets the service id of the Channel.
         *
         * @param serviceId The value of {@link TvContract.Channels#COLUMN_SERVICE_ID} for the
         * channel.
         * @return This Builder object to allow for chaining of calls to builder methods.
         */
        public Builder setServiceId(int serviceId) {
            mChannel.mServiceId = serviceId;
            return this;
        }

        /**
         * Sets the internal provider data of the channel.
         *
         * @param internalProviderData The value of
         * {@link TvContract.Channels#COLUMN_INTERNAL_PROVIDER_DATA} for the channel.
         * @return This Builder object to allow for chaining of calls to builder methods.
         */
        public Builder setInternalProviderData(String internalProviderData) {
            mChannel.mInternalProviderData = internalProviderData.getBytes();
            return this;
        }

        /**
         * Sets the internal provider data of the channel as raw bytes
         *
         * @param internalProviderData The value of
         * {@link TvContract.Channels#COLUMN_INTERNAL_PROVIDER_DATA} for the channel.
         * @return This Builder object to allow for chaining of calls to builder methods.
         */
        public Builder setInternalProviderData(byte[] internalProviderData) {
            mChannel.mInternalProviderData = internalProviderData;
            return this;
        }

        /**
         * Sets the text to be displayed in the App Linking card.
         *
         * @param appLinkText The value of {@link TvContract.Channels#COLUMN_APP_LINK_TEXT} for the
         * channel.
         * @return This Builder object to allow for chaining of calls to builder methods.
         */
        public Builder setAppLinkText(String appLinkText) {
            mChannel.mAppLinkText = appLinkText;
            return this;
        }

        /**
         * Sets the background color of the App Linking card.
         *
         * @param appLinkColor The value of {@link TvContract.Channels#COLUMN_APP_LINK_COLOR} for
         * the channel.
         * @return This Builder object to allow for chaining of calls to builder methods.
         */
        public Builder setAppLinkColor(int appLinkColor) {
            mChannel.mAppLinkColor = appLinkColor;
            return this;
        }

        /**
         * Sets the icon to be displayed next to the text of the App Linking card.
         *
         * @param appLinkIconUri The value of {@link TvContract.Channels#COLUMN_APP_LINK_ICON_URI}
         * for the channel.
         * @return This Builder object to allow for chaining of calls to builder methods.
         */
        public Builder setAppLinkIconUri(String appLinkIconUri) {
            mChannel.mAppLinkIconUri = appLinkIconUri;
            return this;
        }

        /**
         * Sets the background image of the App Linking card.
         *
         * @param appLinkPosterArtUri The value of
         * {@link TvContract.Channels#COLUMN_APP_LINK_POSTER_ART_URI} for the channel.
         * @return This Builder object to allow for chaining of calls to builder methods.
         */
        public Builder setAppLinkPosterArtUri(String appLinkPosterArtUri) {
            mChannel.mAppLinkPosterArtUri = appLinkPosterArtUri;
            return this;
        }

        /**
         * Sets the App Linking Intent.
         *
         * @param appLinkIntentUri The Intent that should be executed when the App Linking card is
         * selected. Use the method toUri(Intent.URI_INTENT_SCHEME) on your Intentto turn it into a
         * String. See {@link TvContract.Channels#COLUMN_APP_LINK_INTENT_URI}.
         * @return This Builder object to allow for chaining of calls to builder methods.
         */
        public Builder setAppLinkIntentUri(String appLinkIntentUri) {
            mChannel.mAppLinkIntentUri = appLinkIntentUri;
            return this;
        }

        /**
         * Sets whether programs assigned to this channel should be repeated periodically.
         *
         * @param isRepeatable Whether to repeat programs
         * @return This Builder object to allow for chaining of calls to builder methods.
         */
        public Builder setIsRepeatable(boolean isRepeatable) {
            mChannel.mIsRepeatable = isRepeatable;
            return this;
        }

        /**
         * Takes the values of the Builder object and creates a Channel object.
         * @return Channel object with values from the Builder.
         */
        public Channel build() {
            Channel channel = new Channel();
            channel.copyFrom(mChannel);
            if (channel.getOriginalNetworkId() == INVALID_LONG_VALUE) {
                throw new IllegalArgumentException("This channel must have a valid original network " +
                        "id");
            }
            return channel;
        }
    }
}
