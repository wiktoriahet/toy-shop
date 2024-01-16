package pl.hetman.wiktoria.solvd.service.decorator;

public class ReviewDecoratorImpl implements ReviewDecorator{
    @Override
    public String write(String text) {
        return text + "\n";
    }
}
