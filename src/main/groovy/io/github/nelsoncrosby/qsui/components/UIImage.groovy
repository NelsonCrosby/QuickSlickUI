package io.github.nelsoncrosby.qsui.components

import org.newdawn.slick.GameContainer
import org.newdawn.slick.Graphics
import org.newdawn.slick.Image
import org.newdawn.slick.SlickException
import org.newdawn.slick.geom.Rectangle

/**
 * A component that contains text
 */
class UIImage extends UIComponent {
    Image image
    Rectangle crop

    protected UIImage() {}

    @Override
    void update(GameContainer gc, int delta) throws SlickException {

    }

    @Override
    void render(GameContainer gc, Graphics gx) throws SlickException {
        if (crop == null) {
            gx.drawImage(image,
                    bounds.x, bounds.y,
                    (float) bounds.x + bounds.width, (float) bounds.y + bounds.height,
                    0, 0, image.width, image.height
            )
        } else {
            gx.drawImage(image,
                    bounds.x, bounds.y,
                    (float) bounds.x + bounds.width, (float) bounds.y + bounds.height,
                    crop.x, crop.y,
                    (float) crop.x + crop.width, (float) crop.y + crop.height
            )
        }
    }

    /**
     *
     */
    static class Builder extends UIComponent.Builder<UIImage> {
        Builder image(Image image) {
            inst.image = image
            return this
        }
        Builder image(Class relTo, String name, boolean flipped = false) {
            return this.image(new Image(relTo.getResourceAsStream(name), name, flipped))
        }
        Builder image(String imgPath, boolean flipped = false) {
            return this.image(new File(imgPath), flipped)
        }
        Builder image(File imgFile, boolean flipped = false) {
            return this.image(new Image(new FileInputStream(imgFile), imgFile.name, flipped))
        }

        Builder crop(Rectangle cropBounds) {
            inst.crop = cropBounds
            return this
        }
        Builder crop(float x, float y, float x2, float y2) {
            return this.crop(new Rectangle(x, y, (float) x2 - x, (float) y2 - y))
        }

        @Override
        protected UIImage getNewInstance() {
            return new UIImage()
        }

        @Override
        UIImage build() {
            if (inst.bounds.width == 0) {
                inst.bounds.width = inst.crop == null ? inst.image.width : inst.crop.width
            }
            if (inst.bounds.height == 0) {
                inst.bounds.height = inst.crop == null ? inst.image.height : inst.crop.height
            }

            return super.build() as UIImage
        }
    }
}
