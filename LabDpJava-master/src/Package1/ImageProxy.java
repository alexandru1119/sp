package Package1;

public class ImageProxy implements IElement {

    private String _imageName;
    private Image _realImage;

    public ImageProxy(String imageTitle) {
        this._imageName = imageTitle;
    }

    public String get_imageName() {
        return _imageName;
    }

    public void set_imageName(String _imageName) {
        this._imageName = _imageName;
    }

    public Image get_realImage() {
        return _realImage;
    }

    public void set_realImage(Image _realImage) {
        this._realImage = _realImage;
    }


    @Override
    public void print() {
        _realImage = new Image(get_imageName());
        _realImage.print();
    }

    @Override
    public void Accept(IVisitor IVisitor) {
        IVisitor.Visit(this);
    }

    @Override
    public void SetNewValue(String newValue) {
        _realImage.SetNewValue(newValue);
    }
}
