package pl.hetman.wiktoria.solvd.service.decorator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReviewContent extends TextDecorator {

    private static final Logger LOGGER = LogManager.getLogger(ReviewContent.class);

    public ReviewContent(ReviewDecorator reviewDecorator) {
        super(reviewDecorator);
    }

    public String writeReview(String title, String subtitle, String description) {
        LOGGER.info("writeReview(" + title + ", " + subtitle + ", " + description + ")");
        LOGGER.info("writeReview(...)");
        return writeTitle(title, subtitle) + writeDescription(description);
    }

    private String writeTitle(String title, String subtitle) {
        LOGGER.info("writeTitle(" + title + ", " + subtitle + ")");
        LOGGER.info("writeTitle(...)");
        return super.write(title) + addSubtitle(subtitle);
    }

    private String writeDescription(String description) {
        LOGGER.info("writeDescription(" + description + ")");
        LOGGER.info("writeDescription(...)");
        return super.write(description);
    }

    private String addSubtitle(String text) {
        LOGGER.info("addSubtitle(" + text + ")");
        LOGGER.info("addSubtitle(...)");
        return text + "\n";
    }
}
