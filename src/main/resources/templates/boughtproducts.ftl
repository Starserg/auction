<#import "parts/common.ftl" as c>

<@c.page>
    <div class="container">
        <div>
            <h2>Ваши покупки</h2>
            <div class="card-columns">

              <#list products as product>
                  <div class="card mb-4">
                      <div class="card-body">
                          <a href="/product/${product.id}"><h5
                                  class="card-title">${product.name?html}</h5></a>
                          <p class="card-text">${product.description?html}</p>
                              <#if product.getRedemptionPrice()<product.getPrice()></#if>
                      </div>
                      <div class="card-footer">
                          <h4 class="text-info">${product.price} Р</h4>
                      </div>
                      <div class="card-footer">
                          <h4 class="text-info">@${product.owner.getUsername()?html}</h4>
                      </div>
                  </div>
              </#list>
            </div>
        </div>
    </div>
</@c.page>