package com.netflix.backend.services.implementation;

import com.netflix.backend.entities.Video;
import com.netflix.backend.exceptions.ResourceNotFoundException;
import com.netflix.backend.repositories.AwsS3Repository;
import com.netflix.backend.repositories.VideoRepository;
import com.netflix.backend.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoServiceImplementation implements VideoService {
    @Autowired
    private AwsS3Repository awsS3Repository;
    @Autowired
    private VideoRepository videoRepo;
    @Override
    public String getVideoUrl(String videoId) {
        Video video = videoRepo.findById(videoId).orElseThrow(()-> new ResourceNotFoundException("Video"));
        String videoPath =video.getVideoPath();
        return awsS3Repository.getPreSignedUrl(videoPath,video.getVideoLength()*60);
    }

    @Override
    public String getVideoThumbnailUrl(String videoId) {
        Video video = videoRepo.findById(videoId).orElseThrow(()-> new ResourceNotFoundException("Video"));
        return awsS3Repository.getPreSignedUrl(video.getThumbnailPath(),60);
    }

    @Override
    public void setRating(String id, double rating) {

    }
}
