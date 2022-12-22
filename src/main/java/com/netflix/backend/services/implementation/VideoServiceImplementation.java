package com.netflix.backend.services.implementation;

import com.netflix.backend.entities.Video;
import com.netflix.backend.exceptions.InvalidCredentialsException;
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
        if(video.getVideoPath()==null)
            throw new ResourceNotFoundException("video path");
        return awsS3Repository.getPreSignedUrl(videoPath,video.getVideoLength()*60);
    }

    @Override
    public String getVideoThumbnailUrl(String videoId) {
        Video video = videoRepo.findById(videoId).orElseThrow(()-> new ResourceNotFoundException("Video"));
        if(video.getThumbnailPath()==null)
            throw new ResourceNotFoundException("thumbnail");
        return awsS3Repository.getPreSignedUrl(video.getThumbnailPath(),60);
    }

    @Override
    public void setRating(String videoId, double rating) {
        if(rating>=0 && rating<=10) {
            Video video = videoRepo.findById(videoId).orElseThrow(() -> new ResourceNotFoundException("Video"));
            video.setNoOfResponses(video.getNoOfResponses() + 1);
            double newRating = (video.getRating() + rating) / video.getNoOfResponses();
            video.setRating(newRating);
            videoRepo.save(video);
        }
        else
            throw new InvalidCredentialsException("Rating should be between 0-10");
    }
}
