package pl.hetman.wiktoria.solvd.service.decorator;

public abstract class TextDecorator implements ReviewDecorator{
    private ReviewDecorator reviewDecorator;

    public TextDecorator(ReviewDecorator reviewDecorator) {
        this.reviewDecorator = reviewDecorator;
    }

    @Override
    public String write(String text) {
        return reviewDecorator.write(text);
    }
}
