CREATE OR REPLACE TRIGGER update_product_count AFTER
    INSERT OR DELETE OR UPDATE ON products
    FOR EACH ROW
DECLARE
    l_cat_id     categories.category_id%TYPE;
    l_old_cat_id categories.category_id%TYPE;
    l_new_cat_id categories.category_id%TYPE;
BEGIN
    IF inserting THEN
        l_cat_id := :new.category_id;
        UPDATE categories
        SET
            product_count = product_count + 1
        WHERE
            category_id = l_cat_id;

    ELSE
        IF deleting THEN
            l_cat_id := :old.category_id;
            UPDATE categories
            SET
                product_count = product_count - 1
            WHERE
                category_id = l_cat_id;

        ELSE
            IF updating THEN
                l_old_cat_id := :old.category_id;
                l_new_cat_id := :new.category_id;
                UPDATE categories
                SET
                    product_count = product_count - 1
                WHERE
                    category_id = l_old_cat_id;

                UPDATE categories
                SET
                    product_count = product_count + 1
                WHERE
                    category_id = l_new_cat_id;
            END IF;
        END IF;
    END IF;
END;

execute add_product(104,'samsung galaxy',110000,'new mobile from samsung',2);

DELETE FROM products
WHERE
    isbn = 104;
    
    update products set products.category_id=3 where products.isbn=103;

SELECT
    *
FROM
    categories;