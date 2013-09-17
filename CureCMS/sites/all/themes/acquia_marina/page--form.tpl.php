<?php
/**
 * @theme acquia_marina
 * @file page.tpl.php
 * @todo list available variables
 */
?>

<div id="page" class="page xform-page">
  <div id="page-inner" class="page-inner">
    <?php print render($page['header_top']); ?>

    <!-- header-group region: width = grid_width -->
    <div id="header-group-wrapper" class="header-group-wrapper full-width clearfix">
      <div id="header-group" class="header-group region <?php print $grid_width; ?>">
        <div id="header-group-inner" class="header-group-inner inner clearfix">

          <?php if ($logo || $site_name || $site_slogan): ?>
          <div id="header-site-info" class="header-site-info">
            <div id="header-site-info-inner" class="header-site-info-inner gutter">
              <?php if ($logo): ?>
              <div id="logo">
                <a href="<?php print check_url($front_page); ?>" title="<?php print t('Home'); ?>"><img src="<?php print $logo; ?>" alt="<?php print t('Home'); ?>" /></a>
              </div>
              <?php endif; ?>
              <?php if ($site_name || $site_slogan): ?>
              <div id="site-name-wrapper" class="clearfix">
                <?php if ($site_name): ?>
                <?php if ($title): ?>
                  <div id="site-name"><a href="<?php print check_url($front_page); ?>" title="<?php print t('Home'); ?>" rel="home"><?php print $site_name; ?></a></div>
                  <?php else: /* Use h1 when the content title is empty */ ?>
                  <h1 id="site-name"><a href="<?php print check_url($front_page); ?>" title="<?php print t('Home'); ?>" rel="home"><?php print $site_name; ?></a></h1>
                  <?php endif; ?>
                <?php endif; ?>
                <?php if ($site_slogan): ?>
                <span id="slogan"><?php print $site_slogan; ?></span>
                <?php endif; ?>
              </div><!-- /site-name-wrapper -->
              <?php endif; ?>
            </div><!-- /header-site-info-inner -->
          </div><!-- /header-site-info -->
          <?php endif; ?>

          <?php print render($page['header']); ?>
        </div><!-- /header-group-inner -->

        <?php print render($page['main_menu']); ?>
      </div><!-- /header-group -->
    </div><!-- /header-group-wrapper -->

    <div id="preface-top-outer"><?php print render($page['preface_top']); ?> </div>

    <!-- main region: width = grid_width -->
    <div id="main-wrapper" class="main-wrapper full-width clearfix">
      <div id="main" class="main region <?php print $grid_width; ?>">
        <div id="main-inner" class="main-inner inner clearfix">
          <?php print render($page['sidebar_first']); ?>

          <!-- main group: width = grid_width - sidebar_first_width -->
          <div id="main-group" class="main-group region nested <?php print $main_group_width; ?>">
            <div id="main-group-inner" class="main-group-inner inner">
              <?php print render($page['preface_bottom']); ?>

              <div id="main-content" class="main-content region nested">
                <div id="main-content-inner" class="main-content-inner inner">
                  <!-- content group: width = grid_width - sidebar_first_width - sidebar_second_width -->
                  <div id="content-group" class="content-group region nested <?php print $content_group_width; ?>">
                    <div id="content-group-inner" class="content-group-inner inner">
                      <?php print theme('grid_block', array('content' => $breadcrumb, 'id' => 'breadcrumbs')); ?>

                      <?php print render($page['content_top']); ?>

                      <div id="content-region" class="content-region region nested">
                        <div id="content-region-inner" class="content-region-inner inner">

                          <a name="main-content-area" id="main-content-area"></a>

                          <?php print drupal_render_children($page['content_top_left']); ?>

                          <?php print theme('grid_block', array('content' => render($tabs), 'id' => 'content-tabs')); ?>
                          <?php print theme('grid_block', array('content' => render($page['help']), 'id' => 'content-help')); ?>

                          <?php print render($title_prefix); ?>
                          <?php if ($title): ?>
                          <h1 class="title gutter"><?php print $title; ?></h1>
                          <?php endif; ?>
                          <?php print render($title_suffix); ?>
                          <?php if ($action_links): ?>
                          <ul class="action-links"><?php print render($action_links); ?></ul>
                          <?php endif; ?>
                          <?php print theme('grid_block', array('content' => $messages, 'id' => 'content-messages')); ?>
                          <?php if (isset($_SESSION['xml_arg']) && !empty($_SESSION['xml_arg']['body'])):
                          $xml = $_SESSION['xml_arg'];
                          $block_id = '';
                          $xml_body = '';
                          if (isset($xml['body'])) {
                            $xml_body = $xml['body'];
                          }
                          if (isset($xml['block_id'])) {
                            $block_id = $xml['block_id'];
                          }
                          ?>
                          <div id="xform-block" class="xform-block block block-<?php echo $block_id; ?>"><?php echo $xml_body; ?></div>
                          <?php endif; ?>
                          <?php print $feed_icons; ?>
                        </div><!-- /content-region-inner -->
                      </div><!-- /content-region -->
                      <?php render($page['content_bottom']); ?>
                    </div><!-- /content-group-inner -->
                  </div><!-- /content-group -->

                  <?php print render($page['sidebar_second']); ?>
                </div><!-- /main-content-inner -->
              </div><!-- /main-content -->

              <?php print render($page['postscript_top']); ?>
            </div><!-- /main-group-inner -->
          </div><!-- /main-group -->
        </div><!-- /main-inner -->
      </div><!-- /main -->
    </div><!-- /main-wrapper -->

    <?php print render($page['postscript_bottom']); ?>
    <div class="footer-wrapper">
      <?php print render($page['footer']); ?>
    </div>
    <?php print render($page['copyright']); ?>
  </div><!-- /page-inner -->
</div><!-- /page -->
