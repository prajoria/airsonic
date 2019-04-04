package org.airsonic.player.service.playlist;

import chameleon.content.Content;
import chameleon.playlist.Media;
import chameleon.playlist.Playlist;
import chameleon.playlist.SpecificPlaylist;
import chameleon.playlist.SpecificPlaylistProvider;
import org.airsonic.player.dao.MediaFileDao;
import org.airsonic.player.domain.MediaFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

@Component
public class DefaultPlaylistExportHandler implements PlaylistExportHandler {

    @Autowired
    MediaFileDao mediaFileDao;

    private boolean exportForMobile;

    @Override
    public boolean canHandle(Class<? extends SpecificPlaylistProvider> providerClass) {
        return true;
    }

    public boolean getExportForMobile() {
        return exportForMobile;
    }

    public void setExportForMobile(boolean exportForMobile) {
        this.exportForMobile = exportForMobile;
    }

    @Override
    public SpecificPlaylist handle(int id, SpecificPlaylistProvider provider) throws Exception {
        chameleon.playlist.Playlist playlist = createChameleonGenericPlaylistFromDBId(id);
        return provider.toSpecificPlaylist(playlist);
    }

    Playlist createChameleonGenericPlaylistFromDBId(int id) {
        Playlist newPlaylist = new Playlist();
        List<MediaFile> files = mediaFileDao.getFilesInPlaylist(id);

        files.forEach(file -> {
            Media component = new Media();
            Content content = null;
            if(exportForMobile) {
                File filePath = new File(file.getPath());
                String path = ".." + filePath.getParent().replace(file.getFolder(), "").replace("\\", "/") + "/" + String.format("%02d", file.getTrackNumber()) + "-" + file.getTitle() + "." + file.getFormat();
                content = new Content(path);
            }else {
                content = new Content(file.getPath());
            }
            component.setSource(content);
            newPlaylist.getRootSequence().addComponent(component);
        });
        return newPlaylist;
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
