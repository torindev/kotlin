package some_java;

import java.util.*;

public class RemoteMediaItem {

    public static List<RemoteMediaItem> getTestList() {
        List<RemoteMediaItem> list = new ArrayList<>();
        String[] creators = {
                "Creator1",
                "Creator2",
                "Creator3",
        };
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            list.add(new RemoteMediaItem(UUID.randomUUID().toString(), creators[random.nextInt(creators.length)]));
        }
        return list;
    }

    private String mUUID;
    private String mEventID;
    private long mCreatedAt;
    private String mCreator;
    private boolean mIsHiden;
    private String mIsHidenUserUID;
    private String mResourceType;
    private String mResourceUrl;

    public RemoteMediaItem(String mUUID, String mCreator) {
        this.mUUID = mUUID;
        this.mCreator = mCreator;
    }

    public String getmUUID() {
        return mUUID;
    }

    public void setmUUID(String mUUID) {
        this.mUUID = mUUID;
    }

    public String getmEventID() {
        return mEventID;
    }

    public void setmEventID(String mEventID) {
        this.mEventID = mEventID;
    }

    public long getmCreatedAt() {
        return mCreatedAt;
    }

    public void setmCreatedAt(long mCreatedAt) {
        this.mCreatedAt = mCreatedAt;
    }

    public String getmCreator() {
        return mCreator;
    }

    public void setmCreator(String mCreator) {
        this.mCreator = mCreator;
    }

    public boolean ismIsHiden() {
        return mIsHiden;
    }

    public void setmIsHiden(boolean mIsHiden) {
        this.mIsHiden = mIsHiden;
    }

    public String getmIsHidenUserUID() {
        return mIsHidenUserUID;
    }

    public void setmIsHidenUserUID(String mIsHidenUserUID) {
        this.mIsHidenUserUID = mIsHidenUserUID;
    }

    public String getmResourceType() {
        return mResourceType;
    }

    public void setmResourceType(String mResourceType) {
        this.mResourceType = mResourceType;
    }

    public String getmResourceUrl() {
        return mResourceUrl;
    }

    public void setmResourceUrl(String mResourceUrl) {
        this.mResourceUrl = mResourceUrl;
    }
}
