package pl.hetman.wiktoria.solvd.service.decorator;

public class ReviewContent extends TextDecorator{

    public ReviewContent(ReviewDecorator reviewDecorator) {
        super(reviewDecorator);
    }

    public String writeReview(String title, String subtitle, String description){
        return writeTitle(title, subtitle) + writeDescription(description);
    }

    private String writeTitle(String title, String subtitle){
        return super.write(title) + addSubtitle(subtitle);
    }

    private String writeDescription(String description){
        return super.write(description);
    }

    private String addSubtitle(String text){
        return text + "\n";
    }
}
