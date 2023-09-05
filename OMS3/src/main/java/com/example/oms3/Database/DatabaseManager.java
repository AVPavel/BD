//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.oms3.Database;

import com.example.oms3.model.Orders;
import com.example.oms3.model.Product;
import com.example.oms3.model.User;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.example.oms3.Extra.Tools.showAlert;
//import org.jetbrains.annotations.NotNull;

public class DatabaseManager {
    private Connection connection;

    public DatabaseManager(Connection connection) throws SQLException {
        this.connection = connection;
    }

    public boolean addUser(User user) {
        String storedProc = "CALL insertuser(?, ?, ?, ?, ?, ?, ?)";

        try {
            CallableStatement cs = this.connection.prepareCall(storedProc);

            boolean var4;
            try {
                cs.setString(1, user.getUsername());
                cs.setString(2, user.getPassword());
                cs.setString(3, user.getEmail());
                cs.setString(4, user.getFirstName());
                cs.setString(5, user.getLastName());
                cs.setString(6, user.getAddress());
                cs.setString(7, user.getPhone());
                cs.executeUpdate();
                var4 = true;
            } catch (Throwable var7) {
                if (cs != null) {
                    try {
                        cs.close();
                    } catch (Throwable var6) {
                        var7.addSuppressed(var6);
                    }
                }

                throw var7;
            }

            if (cs != null) {
                cs.close();
            }

            return var4;
        } catch (SQLException var8) {
            var8.printStackTrace();
            return false;
        }
    }

    public boolean LoginUser(User user) {
        ResultSet rs = null;
        CallableStatement cs = null;

        boolean var5;
        try {
            rs = this.getUserByNameAndPass(user.getUsername(), user.getPassword());
            if (!rs.next()) {
                throw new SQLException(rs.toString());
            }

            boolean var4 = true;
            return var4;
        } catch (SQLException var15) {
            var15.printStackTrace();
            var5 = false;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (cs != null) {
                    ((CallableStatement)cs).close();
                }
            } catch (SQLException var14) {
                var14.printStackTrace();
            }

        }

        return var5;
    }

    public ResultSet getUserByNameAndPass(String name, String pass) throws SQLException {
        String select = "SELECT * from selectuser(?, ?)";
        CallableStatement cs = this.connection.prepareCall(select);

        try {
            cs.setString(1, name);
            cs.setString(2, pass);
            return cs.executeQuery();
        } catch (SQLException var6) {
            var6.printStackTrace();
            return null;
        }
    }

    public boolean openAdmin(User user) {
        if (user == null) {
            showAlert("error","user is null");
        }

        ResultSet rs = null;

        boolean var4;
        try {
            rs = this.getUserByNameAndPass(user.getUsername(), user.getPassword());
            if (rs.next()) {
                boolean var3 = rs.getBoolean("is_admin");
                return var3;
            }

            return false;
        } catch (SQLException var15) {
            var15.printStackTrace();
            var4 = false;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException var14) {
                var14.printStackTrace();
            }

        }

        return var4;
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList();
        String select = "SELECT * FROM products";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(select);

            try {
                ResultSet rs = stmt.executeQuery();

                try {
                    while(rs.next()) {
                        Product product = new Product();
                        product.setProductId(rs.getInt("product_id"));
                        product.setProductName(rs.getString("product_name"));
                        product.setCategoryId(rs.getInt("category_id"));
                        product.setBrandID(rs.getInt("brand_id"));
                        product.setSupplierID(rs.getInt("supplier_id"));
                        product.setPrice(rs.getDouble("price"));
                        product.setDescription(rs.getString("description"));
                        product.setStock(rs.getInt("stock_quantity"));
                        products.add(product);
                    }
                } catch (Throwable var9) {
                    if (rs != null) {
                        try {
                            rs.close();
                        } catch (Throwable var8) {
                            var9.addSuppressed(var8);
                        }
                    }

                    throw var9;
                }

                if (rs != null) {
                    rs.close();
                }
            } catch (Throwable var10) {
                if (stmt != null) {
                    try {
                        stmt.close();
                    } catch (Throwable var7) {
                        var10.addSuppressed(var7);
                    }
                }

                throw var10;
            }

            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException var11) {
            var11.printStackTrace();
        }

        return products;
    }


    public boolean addProduct(Product product) {
        String storedProc = "CALL add_product(?, ?, ?, ?, ?, ?, ?)";

        try {
            CallableStatement cs = this.connection.prepareCall(storedProc);

            boolean var4;
            try {
                cs.setString(1, product.getProductName());
                cs.setInt(2, product.getCategoryId());
                cs.setInt(3, product.getBrandID());
                cs.setInt(4, product.getSupplierID());
                cs.setDouble(5, product.getPrice());
                cs.setString(6, product.getDescription());
                cs.setInt(7, product.getStock());
                cs.executeUpdate();
                var4 = true;
            } catch (Throwable var7) {
                if (cs != null) {
                    try {
                        cs.close();
                    } catch (Throwable var6) {
                        var7.addSuppressed(var6);
                    }
                }

                throw var7;
            }

            if (cs != null) {
                cs.close();
            }

            return var4;
        } catch (SQLException var8) {
            var8.printStackTrace();
            return false;
        }
    }

    public boolean deleteProduct(Integer productId) {
        String storedProc = "CALL delete_product(?)";

        try {
            CallableStatement cs = this.connection.prepareCall(storedProc);

            boolean var4;
            try {
                cs.setInt(1, productId);
                cs.executeUpdate();
                var4 = true;
            } catch (Throwable var7) {
                if (cs != null) {
                    try {
                        cs.close();
                    } catch (Throwable var6) {
                        var7.addSuppressed(var6);
                    }
                }

                throw var7;
            }

            if (cs != null) {
                cs.close();
            }

            return var4;
        } catch (SQLException var8) {
            var8.printStackTrace();
            return false;
        }
    }

    public boolean updateProduct(Product product) {
        String storedProc = "CALL update_product(?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            CallableStatement cs = this.connection.prepareCall(storedProc);

            boolean var4;
            try {
                cs.setInt(1, product.getProductId());
                cs.setString(2, product.getProductName());
                cs.setInt(3, product.getCategoryId());
                cs.setInt(4, product.getBrandID());
                cs.setInt(5, product.getSupplierID());
                cs.setBigDecimal(6, BigDecimal.valueOf(product.getPrice()));
                cs.setString(7, product.getDescription());
                cs.setInt(8, product.getStock());
                cs.executeUpdate();
                var4 = true;
            } catch (Throwable var7) {
                if (cs != null) {
                    try {
                        cs.close();
                    } catch (Throwable var6) {
                        var7.addSuppressed(var6);
                    }
                }

                throw var7;
            }

            if (cs != null) {
                cs.close();
            }

            return var4;
        } catch (SQLException var8) {
            var8.printStackTrace();
            return false;
        }
    }

    public int getProductIdByName(String productName) throws SQLException {
        String select = "SELECT product_id FROM products WHERE product_name = ?";
        PreparedStatement stmt = this.connection.prepareStatement(select);

        int var5;
        try {
            stmt.setString(1, productName);
            ResultSet rs = stmt.executeQuery();

            try {
                if (!rs.next()) {
                    throw new SQLException("No product found with the given name.");
                }

                var5 = rs.getInt("product_id");
            } catch (Throwable var9) {
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (Throwable var8) {
                        var9.addSuppressed(var8);
                    }
                }

                throw var9;
            }

            if (rs != null) {
                rs.close();
            }
        } catch (Throwable var10) {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Throwable var7) {
                    var10.addSuppressed(var7);
                }
            }

            throw var10;
        }

        if (stmt != null) {
            stmt.close();
        }

        return var5;
    }
}
