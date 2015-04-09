package de.johni0702.replaystudio.replay;

import java.util.Arrays;
import java.util.Objects;

/**
 * Meta data for replay files.
 */
public class ReplayMetaData {

    /**
     * Whether this is a singleplayer recording.
     */
    private boolean singleplayer;

    /**
     * The server address or the singleplayer world name.
     */
    private String serverName;

    /**
     * Duration of the replay in milliseconds.
     */
    private int duration;

    /**
     * Unix timestamp of when the recording was started in milliseconds.
     */
    private long date;

    /**
     * File format. Defaults to 'MCPR'
     */
    private String fileFormat;

    /**
     * Version of the file format.
     */
    private int fileFormatVersion;

    /**
     * The program which generated the file.
     * Will always be written as "ReplayStudio vXY".
     */
    private String generator;

    /**
     * The entity id of the player manually added to this replay which represents the recording player.
     * Must be a valid entity id (e.g. must not be -1). May not be set.
     */
    private int selfId = -1;

    /**
     * Array of UUIDs of all players which can be seen in this replay.
     */
    private String[] players = new String[0];

    public boolean isSingleplayer() {
        return this.singleplayer;
    }

    public String getServerName() {
        return this.serverName;
    }

    public int getDuration() {
        return this.duration;
    }

    public long getDate() {
        return this.date;
    }

    public String getFileFormat() {
        return this.fileFormat;
    }

    public int getFileFormatVersion() {
        return this.fileFormatVersion;
    }

    public String getGenerator() {
        return this.generator;
    }

    public int getSelfId() {
        return this.selfId;
    }

    public String[] getPlayers() {
        return this.players;
    }

    public void setSingleplayer(boolean singleplayer) {
        this.singleplayer = singleplayer;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    public void setFileFormatVersion(int fileFormatVersion) {
        this.fileFormatVersion = fileFormatVersion;
    }

    public void setGenerator(String generator) {
        this.generator = generator;
    }

    public void setSelfId(int selfId) {
        this.selfId = selfId;
    }

    public void setPlayers(String[] players) {
        this.players = players;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof ReplayMetaData)) return false;
        final ReplayMetaData other = (ReplayMetaData) o;
        if (!other.canEqual(this)) return false;
        if (this.singleplayer != other.singleplayer) return false;
        if (!Objects.equals(this.serverName, other.serverName)) return false;
        if (this.duration != other.duration) return false;
        if (this.date != other.date) return false;
        if (!Objects.equals(this.fileFormat, other.fileFormat)) return false;
        if (this.fileFormatVersion != other.fileFormatVersion) return false;
        if (!Objects.equals(this.generator, other.generator)) return false;
        if (this.selfId != other.selfId) return false;
        if (!Arrays.deepEquals(this.players, other.players)) return false;
        return true;
    }

    public int hashCode() {
        int result = 1;
        result = result * 59 + (this.singleplayer ? 79 : 97);
        result = result * 59 + (serverName == null ? 0 : serverName.hashCode());
        result = result * 59 + this.duration;
        result = result * 59 + (int) (date >>> 32 ^ date);
        result = result * 59 + (fileFormat == null ? 0 : fileFormat.hashCode());
        result = result * 59 + this.fileFormatVersion;
        result = result * 59 + (generator == null ? 0 : generator.hashCode());
        result = result * 59 + this.selfId;
        result = result * 59 + Arrays.deepHashCode(this.players);
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof ReplayMetaData;
    }

    public String toString() {
        return "ReplayMetaData(singleplayer=" + this.singleplayer + ", serverName=" + this.serverName + ", duration=" + this.duration + ", date=" + this.date + ", fileFormat=" + this.fileFormat + ", fileFormatVersion=" + this.fileFormatVersion + ", generator=" + this.generator + ", selfId=" + this.selfId + ", players=" + java.util.Arrays.deepToString(this.players) + ")";
    }
}
