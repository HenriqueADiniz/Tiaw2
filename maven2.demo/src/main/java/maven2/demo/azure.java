package maven2.demo;
import com.microsoft.azure.cognitiveservices.vision.computervision.*;
import com.microsoft.azure.cognitiveservices.vision.computervision.implementation.ComputerVisionImpl;
import com.microsoft.azure.cognitiveservices.vision.computervision.models.*;

import java.io.*;
import java.nio.file.Files;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Main {

	public class ImageAnalysisQuickstart {

	    static String subscriptionKey = "5c47560ff6f04d1e844b2b2b7249b077";
	    static String endpoint = "https://henriqueteste.cognitiveservices.azure.com/";

	    public static void main(String[] args) {
	        
	        System.out.println("\nAzure Cognitive Services Computer Vision - Java Quickstart Sample");

	        // Create an authenticated Computer Vision client.
	        ComputerVisionClient compVisClient = Authenticate(subscriptionKey, endpoint); 

	        // Analyze local and remote images
	        AnalyzeRemoteImage(compVisClient);

	    }

	    public static ComputerVisionClient Authenticate(String subscriptionKey, String endpoint){
	        return ComputerVisionManager.authenticate(subscriptionKey).withEndpoint(endpoint);
	    }


	    public static void AnalyzeRemoteImage(ComputerVisionClient compVisClient) {
	        /*
	         * Analyze an image from a URL:
	         *
	         * Set a string variable equal to the path of a remote image.
	         */
	        String pathToRemoteImage = "https://github.com/Azure-Samples/cognitive-services-sample-data-files/raw/master/ComputerVision/Images/faces.jpg";

	        // This list defines the features to be extracted from the image.
	        List<VisualFeatureTypes> featuresToExtractFromRemoteImage = new ArrayList<>();
	        featuresToExtractFromRemoteImage.add(VisualFeatureTypes.TAGS);

	        System.out.println("\n\nAnalyzing an image from a URL ...");

	        try {
	            // Call the Computer Vision service and tell it to analyze the loaded image.
	            ImageAnalysis analysis = compVisClient.computerVision().analyzeImage().withUrl(pathToRemoteImage)
	                    .withVisualFeatures(featuresToExtractFromRemoteImage).execute();


	            // Display image tags and confidence values.
	            System.out.println("\nTags: ");
	            for (ImageTag tag : analysis.tags()) {
	                System.out.printf("\'%s\' with confidence %f\n", tag.name(), tag.confidence());
	            }
	        }

	        catch (Exception e) {
	            System.out.println(e.getMessage());
	            e.printStackTrace();
	        }
	    }
	    // END - Analyze an image from a URL.

	}

}
