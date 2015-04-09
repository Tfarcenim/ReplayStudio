package de.johni0702.replaystudio.studio;

import de.johni0702.replaystudio.PacketData;
import de.johni0702.replaystudio.Studio;
import de.johni0702.replaystudio.collection.ReplayPart;
import de.johni0702.replaystudio.collection.ReplayPartView;
import de.johni0702.replaystudio.io.ReplayOutputStream;
import de.johni0702.replaystudio.replay.Replay;
import de.johni0702.replaystudio.replay.ReplayMetaData;
import org.spacehq.packetlib.packet.Packet;

import java.io.*;
import java.util.Collection;
import java.util.ListIterator;

import static com.google.common.base.Preconditions.checkNotNull;

public class StudioDelegatingReplay implements Replay {

    private ReplayMetaData metaData;

    private final Studio studio;

    private final ReplayPart delegate;

    public StudioDelegatingReplay(Studio studio, ReplayPart delegate) {
        this(studio, delegate, null);
    }

    public StudioDelegatingReplay(Studio studio, ReplayPart delegate, ReplayMetaData metaData) {
        this.studio = checkNotNull(studio);
        this.delegate = checkNotNull(delegate);
        this.metaData = metaData;
    }

    @Override
    public void save(File file) throws IOException {
        save(new BufferedOutputStream(new FileOutputStream(file)), false);
    }

    @Override
    public void save(OutputStream output, boolean raw) throws IOException {
        if (raw) {
            ReplayOutputStream.writePackets(studio, output, this);
        } else {
            ReplayOutputStream.writeReplay(studio, output, this);
        }
    }

    public ReplayMetaData getMetaData() {
        return this.metaData;
    }

    public void setMetaData(ReplayMetaData metaData) {
        this.metaData = metaData;
    }

    public ReplayPart copy() {
        return this.delegate.copy();
    }

    public ListIterator<PacketData> iterator() {
        return this.delegate.iterator();
    }

    public void add(long at, Packet packet) {
        this.delegate.add(at, packet);
    }

    public int size() {
        return this.delegate.size();
    }

    public Collection<PacketData> remove(long from, long to) {
        return this.delegate.remove(from, to);
    }

    public ReplayPartView viewOf(long from, long to) {
        return this.delegate.viewOf(from, to);
    }

    public void add(Iterable<PacketData> packets) {
        this.delegate.add(packets);
    }

    public ReplayPart copyOf(long from, long to) {
        return this.delegate.copyOf(from, to);
    }

    public ReplayPartView viewOf(long from) {
        return this.delegate.viewOf(from);
    }

    public long length() {
        return this.delegate.length();
    }

    public ReplayPart append(ReplayPart part) {
        return this.delegate.append(part);
    }

    public void addAt(long offset, Iterable<PacketData> packets) {
        this.delegate.addAt(offset, packets);
    }

    public void add(long at, Iterable<Packet> packets) {
        this.delegate.add(at, packets);
    }

    public ReplayPart copyOf(long from) {
        return this.delegate.copyOf(from);
    }
}
